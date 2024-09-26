package com.oracle.samil.Amodel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

//일정 TBL

@Data
public class Event {
	private int 	eventId;			//일정코드 (참석자 TBL 조인)
	private String 	eventTitle;			//제목
	private int 	eventWriter;		//사원번호
	private LocalDateTime 	eventStartdate;		//시작일
	private LocalDateTime 	eventEnddate;		//종료일
	private int 	eventCategory;		//분류
	private String 	eventMemo;			//메모
	private String 	eventLoc;			//장소
	private String 	eventFile;			//파일첨부
	private int 	LeaveFormatId;		//문서서식ID (전자결재문서 TBL 조인)
	private int 	LeaveNumber;		//결재문서번호 (전자결재문서 TBL 조인)
	private int 	eventDelete;		//삭제여부
	
	// 포맷된 날짜 필드 추가
    private String formatStartdate;
    private String formatEnddate;
    private String formatStartTime;

    // 날짜 포맷터
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    private static final DateTimeFormatter formatterT = DateTimeFormatter.ofPattern("HH:mm");

    // 포맷팅 메소드
    public String getFormatStartdate() {
        return eventStartdate != null ? eventStartdate.format(formatter) : null;
    }

    public String getFormatEnddate() {
        return eventEnddate != null ? eventEnddate.format(formatter) : null;
    }
    
    public String getFormatStartTime() {
    	return eventStartdate !=null ? eventStartdate.format(formatterT) : null;
    }
}
