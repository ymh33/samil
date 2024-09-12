package com.oracle.samil.Amodel;

import lombok.Data;

@Data
public class Utility {
		private int   	utilityYyyymm;		//해당년월
		private int   	utilityDetail;		//세부
		private int   	empno;				//사원번호
		private int   	codeNum;			//비용항목코드
		private String	utilityAttach;		//증빙서류
		private int  	utilityCost;		//비용
}
