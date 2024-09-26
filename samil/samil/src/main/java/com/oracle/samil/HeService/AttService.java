package com.oracle.samil.HeService;

import java.time.LocalDate;
import java.util.List;

import com.oracle.samil.ADto.AttLeave;

public interface AttService {
	List<AttLeave> myAttList(int empno);
	List<AttLeave> myLeaveList(int empno);
	List<AttLeave> deptAttList(int deptno);
	List<AttLeave> deptLeaveList(int deptno);
	void clockIn(int empno, String workDate, String clockInTime, String clockOutTime);
	void clockOut(int empno, String workDate);
	void updateAttStatus();
	void calOvertime(int empno, LocalDate now);
	void calculateWorkTimes(List<AttLeave> myAtt);
}
