package com.oracle.samil.Amodel;

import lombok.Data;

@Data
public class Attendance {
	public int 		empno;		// 사원번호
	public String	workDate;	// 근무날짜
	public String	clockIn;	// 출근시간
	public String	clockOut;	// 퇴근시간
	public String	overTime;	// 초과근무시간
	public int		attStatus;	// 출근상태
	public int		editCheck;	// 수정여부
	public int		editWho;	// 수정자
	public String	editWhen;	// 수정날짜
}
