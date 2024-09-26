package com.oracle.samil.HsService;

import java.util.List;

import com.oracle.samil.Amodel.FacilApprove;
import com.oracle.samil.Amodel.Facility;
import com.oracle.samil.Amodel.Reservation;

public interface HsResService {

	List<Reservation> 	listload(Reservation res, int empno);
	List<FacilApprove> 	listFacilAcc(FacilApprove faAp, int empno);
	List<FacilApprove> 	listFacilRej(FacilApprove faAp, int empno);
	int 				insertReserv(Reservation res, int empno);
	List<Facility> 		facilSortlist();
	int 				updateReserv(Reservation res, int empno);
	Reservation 		detailRes(int resCode, int empno);
	int 				deleteRes(int resCode, int empno);
	List<Facility> 		listfacil(Facility facil);
	Facility 			detailfacil(int facilId);
	int 				insertFacil(Facility facil);
	int 				updateFac(Facility facil, int empno);
	List<Reservation> 	listappr(Reservation res, int empno);
	int 				deleteFacil(int facilId, int empno);
	int 				insertResRea(FacilApprove facAp, int empno);
	int 				updateResState(FacilApprove facAp, int empno);

}
