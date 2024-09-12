package com.oracle.samil.Amodel;

import lombok.Data;

@Data
public class MailFile {
	
	private int 	empno;		//사원번호
	private int 	mailNo;		//메일번호
	private int 	fileNo;		//파일번호
	private String 	fileName;	//파일명

}
