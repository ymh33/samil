package com.oracle.samil.HeDao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import com.oracle.samil.ADto.AttLeave;
import com.oracle.samil.Amodel.Attendance;
import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.Amodel.FurloughDetails;

public interface AttDao {
	List<AttLeave> myAttList(int empno);
	List<AttLeave> myLeaveList(int empno);
	List<AttLeave> deptAttList(int deptno);
	List<AttLeave> deptLeaveList(int deptno);
	void insertClockIn(Map<String, Object> params);
	void updateClockOut(String string, Map<String, Object> params);
	void updateAttStatus();
	void calOvertime(int empno, LocalDate now);
	void calculateWorkTimes(Map<String, Object> params);
	Boolean isClockedIn(int empno, String currentDate);
	Boolean isClockedOut(int empno, String currentDate);
}
