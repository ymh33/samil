package com.oracle.samil.Amodel;

import lombok.Data;

// 시설예약 TBL

@Data
public class Reservation {
	private int 	resCode;		//예약코드 (시설예약결재 TBL 조인)
	private int 	facilId;		//시설코드종류(시설종류 TBL 조인)
	private String 	resDate;		//예약날짜
	private String 	resStart;		//시작시간
	private String 	resEnd;			//종료시간
	private String 	resContent;		//예약내용
	private int 	resWriter;		//사원번호 (사원 TBL 조인)
	private String 	resTel;			//연락처
	private String 	resRequest;		//요청사안
	private int 	resState;		//예약상태
	
}
