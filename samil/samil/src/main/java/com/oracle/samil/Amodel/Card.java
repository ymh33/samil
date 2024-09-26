package com.oracle.samil.Amodel;

import lombok.Data;

@Data
public class Card {
	private String	cardNum;				//카드번호
	private String	cardBank;				//카드사
	private int 	   	cardPermit;			//분실신청
	private String cardLostDate;	//분실신청일자
	private int 	   	cardDelGubun;	//삭제여부
	private String cardDelDate;		//삭제처리일자
	private int  	   	empno;					//사원번호
	
	// join용
	private String name;			
	private String deptno;

}


