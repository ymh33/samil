package com.oracle.samil.Amodel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

//참석자 TBL

@Data
public class Attendee {
	
	//참석자 TBL
	private int eventId;		//일정코드(일정 TBL 조인)
	private int attendId;		//참석자 사원번호(사원TBL 조인)
	private int attendRes;		//참석자 요청응답
	private int attendRsvp;		//참석자 수정권한
	
	//일정 TBL
    private String eventTitle;      // 제목
    private int eventWriter;        // 사원 번호
    private LocalDateTime eventStartdate; // 시작일
    private LocalDateTime eventEnddate;   // 종료일
    private int eventCategory;      // 분류
    private String eventMemo;       // 메모
    private String eventLoc;        // 장소
    private String eventFile;       // 파일첨부
    private int eventDelete;        // 삭제 여부
    
    private String formatStartdate; // 포맷된 시작일
    private String formatEnddate;   // 포맷된 종료일
    
    //사원번호 TBL
    private String 	name;			//이름
    private String  empno;			//사번
    
    private static final DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    private static final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
    
    public String getFormatStartdate() {
        return eventStartdate != null ? eventStartdate.format(formatter1) : null;
    }

    public String getFormatEnddate() {
        return eventEnddate != null ? eventEnddate.format(formatter2) : null;
    }
}
