package com.oracle.samil.Amodel;

import lombok.Data;

//일정 TBL

@Data
public class Event {
	private int 	eventId;			//일정코드 (참석자 TBL 조인)
	private String 	eventTitle;			//제목
	private int 	eventWriter;		//사원번호
	private String 	eventStartdate;		//시작일
	private String 	eventEnddate;		//종료일
	private String 	eventStart;			//시작시간
	private String 	eventEnd;			//종료시간
	private int 	eventCategory;		//분류
	private String 	eventMemo;			//메모
	private String 	eventLoc;			//장소
	private String 	eventFile;			//파일첨부
	private int 	LeaveFormatId;		//문서서식ID (전자결재문서 TBL 조인)
	private int 	LeaveNumber;		//결재문서번호 (전자결재문서 TBL 조인)
	private int 	eventDelete;		//삭제여부
}
