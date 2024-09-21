package com.oracle.samil.Amodel;

import lombok.Data;

@Data
public class CardUse {
	private int  	usenum;			//사용순서
	private int	  	cardNum;		//카드번호
	private int 	cardCost;		//금액
	private String 	place;			//가맹점
	private String 	useDate;		//카드사용일자
	private String 	cardPaper;		//증빙서류
		
}
