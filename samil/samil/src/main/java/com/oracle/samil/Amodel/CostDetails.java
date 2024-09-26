package com.oracle.samil.Amodel;

import lombok.Data;

@Data
public class CostDetails {
	public int 		documentformatId;	//문서서식ID
	public int 		documentNum;		//결재문서번호
	public int 		costDetailsNum;		//상세번호
	public int 		costDetailsCode;	//항목코드
	public String 	costDetailsCnt;		//내용
	public int 		costQuantity;		//수량
	public int 		costUnitPrice;		//단가
	public int 		costAmount;			//금액
}
