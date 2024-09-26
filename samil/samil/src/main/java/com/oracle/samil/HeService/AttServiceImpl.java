package com.oracle.samil.HeService;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.samil.ADto.AttLeave;
import com.oracle.samil.HeDao.AttDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttServiceImpl implements AttService {

	@Autowired
	private final AttDao ad;

	@Override
	public List<AttLeave> myAttList(int empno) {
		return ad.myAttList(empno);
	}

	@Override
	public List<AttLeave> myLeaveList(int empno) {
		return ad.myLeaveList(empno);
	}

	@Override
	public List<AttLeave> deptAttList(int deptno) {
		return ad.deptAttList(deptno);
	}
	
	@Override
	public List<AttLeave> deptLeaveList(int deptno) {
		return ad.deptLeaveList(deptno);
	}

    private String getCurrentWorkDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 원하는 형식으로 조정
        return sdf.format(new Date());
    }

    @Override
    public void clockIn(int empno, String workDate, String clockInTime, String clockOutTime) {
        Map<String, Object> params = new HashMap<>();
        params.put("empno", empno);
        params.put("workDate", workDate);
        params.put("clockIn", clockInTime);
        params.put("clockOut", clockOutTime); // 퇴근 시간 '00:00'

        ad.insertClockIn(params); // 출근 기록을 수행하는 메서드
    }

    @Override
    public void clockOut(int empno, String currentTime) {
        Map<String, Object> params = new HashMap<>();
        params.put("empno", empno);
        params.put("workDate", getCurrentWorkDate()); // 현재 날짜 가져오기
        params.put("clockOut", currentTime);

        ad.updateClockOut("updateClockOut", params);
    }

	@Override
	public void updateAttStatus() {
		ad.updateAttStatus();
	}

	@Override
	public void calOvertime(int empno, LocalDate now) {
		ad.calOvertime(empno, now);
	}

	@Override
	public void calculateWorkTimes(List<AttLeave> myAtt) {
	    for (AttLeave att : myAtt) {
	        if (att.getClockIn() != null && att.getClockOut() != null) {
	            Map<String, Object> params = new HashMap<>();
	            params.put("clockIn", att.getClockIn());
	            params.put("clockOut", att.getClockOut());

	            // totalWorkTime을 Double로 선언하여 초기화
	            double totalWorkTime = 0.0;
	            params.put("totalWorkTime", totalWorkTime);

	            // 프로시저 호출
	            ad.calculateWorkTimes(params);

	            // 총 근로 시간을 근태 기록에 설정 (Double에서 long으로 변환)
	            Double retrievedTotalWorkTime = (Double) params.get("totalWorkTime"); // Double로 가져오기
	            long totalHours = retrievedTotalWorkTime != null ? Math.round(retrievedTotalWorkTime) : 0; // 반올림
	            att.setTotWorkTime(Duration.ofHours(totalHours)); // Duration에 설정

	            // overTime은 설정하지 않음
	            att.setOverTime("0시간"); // 기본적으로 0시간으로 설정
	        }
	    }
	}
}
