package com.oracle.samil.Amodel;

import lombok.Data;

//시설예약결재 TBL

@Data
public class FacilApprove {
	private int 	resCode;		//예약코드 (시설예약 TBL 조인)
	private int 	empno;			//관리자번호 (사원 TBL 조인)
	private int 	resApprove;		//승인여부
	private String 	resDetail;		//승인여부사유
}
