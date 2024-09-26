package com.oracle.samil.Amodel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

//시설예약결재 TBL

@Data
public class FacilApprove {
	
	//시설예약 결재 TBL
	private int 	resCode;		//예약코드 (시설예약 TBL 조인)
	private int 	empno;			//관리자번호 (사원 TBL 조인)
	private int 	resApprove;		//승인여부
	private String 	resDetail;		//승인여부사유
	
	//시설종류
	private int 	facilId;	//시설종류코드 (시설예약 TBL 조인)
	private String 	facilType;	//시설종류 (차량 등)
	private String 	facilName;	//시설명
	
	//시설예약 TBL
	private LocalDateTime 	resStart;		//시작시간
	private LocalDateTime 	resEnd;			//종료시간
	private String 			resContent;		//예약내용
	private int 			resWriter;		//사원번호 (사원 TBL 조인)
	private String 			resTel;			//연락처
	private String 			resRequest;		//요청사안
	private int 			resState;		//예약상태
	
	
	//관리자정보
	private int 	admin;			//관리자권한
	private String 	name;			//이름
	
	// 포맷된 날짜 필드 추가
    private String formatResStart;
    private String formatResEnd;

    // 날짜 포맷터
    private static final DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    private static final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
    
    // 포맷팅 메소드
    public String getFormatResStart() {
        return resStart != null ? resStart.format(formatter1) : null;
    }

    public String getFormatResEnd() {
        return resEnd != null ? resEnd.format(formatter2) : null;
    }
}
