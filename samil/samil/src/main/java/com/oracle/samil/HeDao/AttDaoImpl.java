package com.oracle.samil.HeDao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.samil.ADto.AttLeave;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class AttDaoImpl implements AttDao {

	private final SqlSession session;

	@Override
	public List<AttLeave> myAttList(int empno) {
		return session.selectList("myEmpAttList", empno);
	}

	@Override
	public List<AttLeave> myLeaveList(int empno) {
		return session.selectList("myLeaveList", empno);
	}

	@Override
	public List<AttLeave> deptAttList(int deptno) {
		return session.selectList("adminDeptAtt", deptno);
	}

	@Override
	public List<AttLeave> deptLeaveList(int deptno) {
		return session.selectList("adminDeptLeave", deptno);
	}

	@Override
	public void insertClockIn(Map<String, Object> params) {
		session.insert("insertClockIn", params);
	}

	@Override
	public void updateClockOut(String string, Map<String, Object> params) {
		session.update("updateClockOut", params);
	}

	@Override
	public void updateAttStatus() {
		session.update("updateAttendanceStatus");
	}

	@Override
	public void calOvertime(int empno, LocalDate now) {
		Map<String, Object> params = new HashMap<>();
	    params.put("empno", empno);
	    params.put("now", now);

	    session.update("calculateOvertime", params);
	}

	@Override
	public void calculateWorkTimes(Map<String, Object> params) {
		session.insert("calculateTotalWorkTime", params);
	}

	@Override
	public Boolean isClockedIn(int empno, String currentDate) {
		System.out.println("dao isClockedIn");

	    Map<String, Object> params = new HashMap<>();
	    params.put("empno", empno);
	    params.put("workDate", currentDate); // SQL 쿼리에서 사용될 날짜

		Boolean clockedIn = session.selectOne("isClockedIn", params);
		System.out.println("dao clockedIn: " + clockedIn);
		return clockedIn; // null 체크 후 boolean 반환
	}

	@Override
	public Boolean isClockedOut(int empno, String currentDate) {
	    System.out.println("dao isClockedOut");
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("empno", empno);
	    params.put("workDate", currentDate); // SQL 쿼리에서 사용될 날짜

	    Boolean clockedOut = session.selectOne("isClockedOut", params);
	    System.out.println("dao clockedOut: " + clockedOut);
	    return clockedOut;
	}
}
