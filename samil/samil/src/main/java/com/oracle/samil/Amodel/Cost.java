package com.oracle.samil.Amodel;

import lombok.Data;

@Data
public class Cost {
		private int		costYear; 		//비용문서번호
		private int 	empno;			//사원번호
		private int 	codeNum; 	    //비용항목코드
		private String	costTitle;		//제목
		private int		costMoney;   	//금액
		private String  attach;			//첨부파일
		private int     status;			//처리상태
		private String  signdate; 		//신청날짜
		
		//조회용
		  private String search;
		   private String keyword;   
		   private String pageNum;
		   private int start;
		   private int end;

	    //Page 정보
	    private String currentPage;
		  // 기존 필드들...
		  private String name; // 사원 이름 추가
		  private String deptno;   // 부서 번호 추가
		  
		  private String codeName;

}
