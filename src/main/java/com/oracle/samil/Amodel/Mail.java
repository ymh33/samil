package com.oracle.samil.Amodel;

import lombok.Data;

@Data
public class Mail {
	
	private int 	empno;			//사원번호
	private int 	mailNo;			//메일번호
	private String 	sendAddress;	//보낸이메일
	private String 	mailTitle;		//제목
	private String 	mailCnt;		//내용
	private String 	sendDate;		//전송일
	private int 	mailRead;		//읽음여부
	private int  	mailType;		//메일함종류

}
