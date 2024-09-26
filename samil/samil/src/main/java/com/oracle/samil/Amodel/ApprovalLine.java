package com.oracle.samil.Amodel;

import lombok.Data;

@Data
public class ApprovalLine {
	public int 		documentFormId;			//문서서식ID
	public int 		approvalNum;			//결재문서번호
	public int 		approverOrder;			//결재자순서
	public int 		empno;					//결재자사번
	public String 	approvalCompleteDate;	//결재일
	public String 	approvalCnt;			//결재코멘트
	public int 		approvalType;			//결재유형
	
	//이름 
	private String name;
	private String grade;
	private String job;
	
	//부서
	private int	   deptno;
	private String deptName;
	
	public int 		costDetailsNum;		//상세번호
	public int 		costDetailsCode;	//항목코드
	public String 	costDetailsCnt;		//내용
	public int 		costQuantity;		//수량
	public int 		costUnitPrice;		//단가
	public int 		costAmount;			//금액
}
