package com.oracle.samil.HsDao;

import java.util.List;

import com.oracle.samil.Amodel.FacilApprove;
import com.oracle.samil.Amodel.Facility;
import com.oracle.samil.Amodel.Reservation;

public interface HsResDao {

	List<Reservation> 	listload(Reservation res, int empno);
	List<FacilApprove>	listFacilAcc(FacilApprove faAp, int empno);
	List<FacilApprove> 	listFacilRej(FacilApprove faAp, int empno);
	int 				insertReserv(Reservation res, int empno);
	int 				updateReserv(Reservation res, int empno);
	Reservation 		detailRes(int resCode, int empno);
	int 				deleteRes(int resCode, int empno);
	List<Reservation> 	listfacil(Reservation res, int empno);
	int 				insertFacil(FacilApprove facAp, int empno);
	int 				updateFac(FacilApprove facAp, int empno);

}
