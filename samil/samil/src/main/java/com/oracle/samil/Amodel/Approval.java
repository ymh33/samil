package com.oracle.samil.Amodel;

import java.util.Date;

import lombok.Data;

@Data
public class Approval {
	public int 		documentFormId;		//문서서식ID
	public int 		approvalNum;		//결재문서번호
	public int 		empno;				//작성자
	public String 	approvalTitle;		//문서제목
	public int 		approvalCondition;	//결재상태
	public String 	approvalDate;		//기안일자
	public String 	relatedDocuments;	//연관문서
	public String 	imageAttachment;	//파일첨부
	public String 	documentFormTitle;	//문서서식제목
	//조회용
	private String search;			private String keyword;
	private String pageNum;			
	private int    start;			private int    end;
	
	//Page 정보
	private String currentPage;
	
	//이름 
	private String name;
	private String grade;
	private String job;
	
	//부서
	private int	   deptno;
	private String deptName;
	
	//휴무상세
	private Date startDate;
	private Date endDate;
	
	public int 		furloughDetailsCode;	//항목코드
	public String 	furloughStartDate;		//시작일
	public String 	furloughEndDate;		//종료일
	public int 		furloughServiceData;	//사용일수
	public String 	furloughCnt;			//사유
	
	public int 		approverOrder;			//결재자순서
	public int 		approverEmpno;			//결재자사번
	public String 	approvalCompleteDate;	//결재일
	public String 	approvalCnt;			//결재코멘트
	public int 		approvalType;			//결재유형
	
	public int 		costDetailsNum;		//상세번호
	public int 		costDetailsCode;	//항목코드
	public String 	costDetailsCnt;		//내용
	public int 		costQuantity;		//수량
	public int 		costUnitPrice;		//단가
	public int 		costAmount;			//금액
}
