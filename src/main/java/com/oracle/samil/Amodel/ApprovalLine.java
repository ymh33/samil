package com.oracle.samil.Amodel;

import lombok.Data;

@Data
public class ApprovalLine {
	public int 		documentFormId;			//문서서식ID
	public int 		approvalNum;			//결재문서번호
	public int 		approverOrder;			//결재자순서
	public int 		approverName;			//결재자사번
	public String 	approvalCompleteDate;	//결재일
	public String 	approvalCnt;			//결재코멘트
	public int 		approvalType;			//결재유형
}
