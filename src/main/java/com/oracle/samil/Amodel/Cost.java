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
}
