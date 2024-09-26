package com.oracle.samil.Amodel;


import lombok.Data;
//급여 테이블
@Data
public class Sal {
	private String 	salNum;		//근로년월
	private int 	empno;		//사원번호
	private int 	salBase;	//기본급
	private int 	salFood;	//식대
	private int 	salBonus;	//상여
	private int 	salNight;	//야간수당
	private int 	salTotal;	//금여총액
	private int 	taxNum;		//공제총액
	private int 	salFinal;	//차감지급액
	private String 	salDate;	//급여일
	private int 	tax;		//소득세
	private String 	editor;		//작성자
	private String 	editorDate;	//작성일
	

}
