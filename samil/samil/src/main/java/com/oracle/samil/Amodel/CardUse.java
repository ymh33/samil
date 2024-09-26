package com.oracle.samil.Amodel;

import lombok.Data;

@Data
public class CardUse {
	private int  		useNum;			//사용순서
	private String	cardNum;		//카드번호
	private int 		cardCost;		//금액
	private String 	place;			//가맹점
	private String 	useDate;		//카드사용일자
	private String 	cardPaper;		//증빙서류
	
	private int 		empno;
	private String name;
	private int 		deptno;

	//조회용
	  private String search;
	   private String keyword;   
	   private String pageNum;
	   private int start;
	   private int end;

  //Page 정보
	   private String currentPage;
	  // 기존 필드들...
	  
	  private String codeName;

}