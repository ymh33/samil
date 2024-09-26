package com.oracle.samil.ADto;

import java.time.Duration;

import lombok.Data;

@Data
public class AttLeave {
	private int			empno;
	private String		name;
	private int			totalVacation;
	private int			restVacation;
	private int			deptno;
	private String		deptName;
	private String		workDate;
	private String		clockIn;
	private String		clockOut;
	private String		overTime;
	private int			attStatus;
	private int			documentFormId;
	private int			furloughDetailsCode;
	private	int			furloughServiceData;
	private String		furloughStartDate;
	private String		furloughEndDate;
	private Duration	totWorkTime;
}