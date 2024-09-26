package com.oracle.samil.Acontroller;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.samil.ADto.AttLeave;
import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.HeService.AttService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;



@Controller
@RequestMapping(value="/he")
@RequiredArgsConstructor
public class HeAttController {

	@Autowired
	private final AttService as;

	@GetMapping(value = "/att")
	public String att(HttpSession session, Model model) {
	    Emp emp = (Emp) session.getAttribute("emp");

	    // 근태 리스트 조회
	    List<AttLeave> myAtt = as.myAttList(emp.getEmpno());
	    
	    // 프로시저 호출 (update_attendance_status)
	    as.updateAttStatus(); // MyBatis를 통해 프로시저 호출

	    for (AttLeave att : myAtt) {
	        LocalTime clockInTime = LocalTime.parse(att.getClockIn());
	        LocalTime clockOutTime = LocalTime.parse(att.getClockOut());

	        if (clockInTime.equals(LocalTime.of(0, 0)) && clockOutTime.equals(LocalTime.of(0, 0))) {
	        	att.setTotWorkTime(Duration.ZERO);
	        	continue; // 이 경우는 건너뜁니다.
	        }
	        
	        // 출근 시간이 09:00 이전인 경우 09:00으로 설정
	        LocalTime officeTime = clockInTime.isBefore(LocalTime.of(9, 0)) ? LocalTime.of(9, 0) : clockInTime;

	        // 총 근로시간 계산 (야근시간은 고려하지 않음)
	        Duration  totWorkTime  = calTotWorkTime(officeTime, clockInTime, clockOutTime);

	        long hours = totWorkTime.toHours();
	        long minutes = totWorkTime.toMinutesPart();

	        // 30분 이상이면 시 단위로 올림
	        if (totWorkTime.toMinutes() < 30) {
	        	att.setTotWorkTime(Duration.ZERO);
	        } else {
	        	// 30분 이상이면 시 단위로 올림
	            if (minutes >= 30) {
	                hours++;
	            }
	        }

	        // 총 근로시간에서 1시간 차감, 음수 방지
	        att.setTotWorkTime(hours > 0 ? Duration.ofHours(hours - 1) : Duration.ZERO); // 1시간 빼기

	        // 퇴근시간이 기록된 후 CalculateOvertime 프로시저 호출
	        as.calOvertime(att.getEmpno(), LocalDate.now()); // empno와 현재 날짜를 인자로 전달
	        System.out.println("Clock In: " + att.getClockIn());
	        System.out.println("Clock Out: " + att.getClockOut());
	        System.out.println("Total Work Time: " + totWorkTime);
	    }

		// 총 근무 시간 계산
	    as.calculateWorkTimes(myAtt);

	    List<AttLeave> myLeave = as.myLeaveList(emp.getEmpno());
	    System.out.println("HeAttController att myLeave : " + myLeave.size());

	    // 업데이트된 근태 리스트 다시 조회
	    myAtt = as.myAttList(emp.getEmpno());

	    model.addAttribute("myAtt", myAtt);
	    model.addAttribute("myLeave", myLeave);
	    return "he/att";
	}

	private Duration calTotWorkTime(LocalTime officeTime, LocalTime clockInTime, LocalTime clockOutTime) {
	    // clockIn과 clockOut이 모두 존재하는지 확인
	    if (clockInTime != null && clockOutTime != null) {
	        Duration workDuration = Duration.between(officeTime, clockOutTime);

	    // 근무 시간이 음수일 경우 처리 (예: 출근 시간이 퇴근 시간 이후인 경우)
	    return workDuration.isNegative() ? Duration.ZERO : workDuration; // 음수일 경우 0으로 설정
	    }
	    return Duration.ZERO; // 시간 정보가 없을 경우 0으로 설정
	}

	@GetMapping(value = "/adminAtt")
	public String adminAtt (HttpSession session, Model model) {
		Emp emp = (Emp) session.getAttribute("emp");

		List<AttLeave> deptAtt = as.deptAttList(emp.getDeptno());

		for (AttLeave att : deptAtt) {
			LocalTime clockInTime  = LocalTime.parse(att.getClockIn());
			LocalTime officeTime;

			if (clockInTime.isBefore(LocalTime.of(9, 0))) {
				officeTime = LocalTime.of(9, 0);
			} else officeTime = clockInTime;

			LocalTime clockOutTime = LocalTime.parse(att.getClockOut());
	        Duration  totWorkTime  = calTotWorkTime(officeTime, clockInTime, clockOutTime);

			long hours	 = totWorkTime.toHours();
			long minutes = totWorkTime.toMinutes();

			if (minutes >= 30) {
				hours++;
			}

			if (hours > 0) {
				att.setTotWorkTime(Duration.ofHours(hours - 1));
			} else att.setTotWorkTime(Duration.ZERO);
		}

		List<AttLeave> deptLeave = as.deptLeaveList(emp.getDeptno());
		System.out.println("HeAttController adminAtt deptLeave : " + deptLeave.size());

	    // 업데이트된 근태 리스트 다시 조회
		deptAtt = as.deptAttList(emp.getDeptno());

		model.addAttribute("deptAtt", deptAtt);
		model.addAttribute("deptLeave", deptLeave);
	    return "he/adminAtt";
	}

	@PostMapping("/att/clockIn")
	@ResponseBody
	public String clockIn(HttpSession session) {
	    Emp emp = (Emp) session.getAttribute("emp");

	    String currentTime = getCurrentTime(); // 현재 시간 가져오는 메서드
	    String workDate = getCurrentDate(); // 오늘 날짜 가져오는 메서드

	    as.clockIn(emp.getEmpno(), workDate, currentTime, "00:00"); // 퇴근 시간을 '00:00'으로 설정
	    return currentTime; // 확인을 위한 현재 시간 반환
	}

	@PostMapping("/adminAtt/checkClockIn")
	@ResponseBody
	public String checkClockIn(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("emp");

		String currentTime = getCurrentTime();
		String workDate = getCurrentDate();
		
		as.clockIn(emp.getEmpno(), workDate, currentTime, "00:00");
		return currentTime;
	}


	@PostMapping("/att/clockOut")
	@ResponseBody
	public String clockOut(HttpSession session) {
	    Emp emp = (Emp) session.getAttribute("emp");
	    String currentTime = getCurrentTime(); // 현재 시간 가져오는 메서드

	    as.clockOut(emp.getEmpno(), currentTime); // 서비스 메서드 호출
	    return currentTime; // 확인을 위한 현재 시간 반환
	}


	@PostMapping("/adminAtt/checkClockOut")
	@ResponseBody
	public String checkClockOut(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("emp");
		String currentTime = getCurrentTime();
		
		as.clockOut(emp.getEmpno(), currentTime);
		return currentTime;
	}

	private String getCurrentDate() {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    return sdf.format(new Date()); // 현재 날짜 반환
	}

	private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(new Date()); // 현재 시간 반환
    }
}
