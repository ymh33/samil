package com.oracle.samil.HsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.samil.Amodel.FacilApprove;
import com.oracle.samil.Amodel.Facility;
import com.oracle.samil.Amodel.Reservation;
import com.oracle.samil.HsDao.HsFacilDao;
import com.oracle.samil.HsDao.HsResDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HsResServiceImpl implements HsResService {
	
	@Autowired
	private final HsResDao hrd;
	private final HsFacilDao hfd;

	@Override
	public List<Reservation> listload(Reservation res, int empno) {
		List<Reservation> listload = null;
		System.out.println("HsResServiceImpl listload Start...");
		listload = hrd.listload(res, empno);
		
		System.out.println("HsResServiceImpl listload After...");
		return listload;
	}

	@Override
	public List<FacilApprove> listFacilAcc(FacilApprove faAp, int empno) {
		List<FacilApprove> listFacilAcc = null;
		System.out.println("HsResServiceImpl listFacilAcc Start...");
		listFacilAcc = hrd.listFacilAcc(faAp, empno);
		System.out.println("HsResServiceImpl listFacilAcc After...");
		
		return listFacilAcc;
	}

	@Override
	public List<FacilApprove> listFacilRej(FacilApprove faAp, int empno) {
		List<FacilApprove> listFacilRej = null;
		System.out.println("HsResServiceImpl listFacilRej Start...");
		listFacilRej = hrd.listFacilRej(faAp, empno);
		System.out.println("HsResServiceImpl listFacilRej After...");
		
		return listFacilRej;
	}

	@Override
	public int insertReserv(Reservation res, int empno) {
		System.out.println("HsResServiceImpl insertReserv Start...");
		int result = hrd.insertReserv(res, empno);
		
		System.out.println("HsResServiceImpl insertReserv result-> "+result);
		System.out.println("HsResServiceImpl insertReserv insertReserv After...");
		return result;
	}

	@Override
	public List<Facility> facilSortlist() {
		System.out.println("HsResServiceImpl facilSortlist Start...");
		List<Facility> facilSort = null;
		facilSort = hfd.facilSortList();
		System.out.println("HsResServiceImpl facilSortlist facilSort.size()-> "+facilSort.size());
		
		System.out.println("HsResServiceImpl facilSortlist After...");
		return facilSort;
	}

	@Override
	public int updateReserv(Reservation res, int empno) {
		System.out.println("HsResServiceImpl updateReserv Start...");
		int updateCount=0;
		updateCount = hrd.updateReserv(res, empno);
		System.out.println("HsResServiceImpl updateReserv updateCount -> "+updateCount);
		System.out.println("HsResServiceImpl updateReserv After...");
		return updateCount;
	}

	@Override
	public Reservation detailRes(int resCode, int empno) {
		System.out.println("HsResServiceImpl detailRes Start...");
		Reservation res = hrd.detailRes(resCode, empno);
		
		System.out.println("HsResServiceImpl detailRes After...");
		return res;
	}

	@Override
	public int deleteRes(int resCode, int empno) {
		System.out.println("HsResServiceImpl deleteRes Start...");
		int result = 0;
		result = hrd.deleteRes(resCode, empno);
		System.out.println("HsResServiceImpl deleteRes result-> "+result);
		
		System.out.println("HsResServiceImpl deleteRes After...");
		return result;
	}

	@Override
	public List<Facility> listfacil(Facility facil) {
		List<Facility> facilSort = null;
		System.out.println("HsResServiceImpl listfacil Start...");
		facilSort = hfd.listfacil(facil);
		
		System.out.println("HsResServiceImpl listfacil After...");
		return facilSort;
	}

	@Override
	public Facility detailfacil(int facilId) {
		System.out.println("HsResServiceImpl detailfacil Start...");
		Facility facil = hfd.detailfacil(facilId);
		System.out.println("HsResServiceImpl detailfacil End...");
		
		return facil;
	}

	@Override
	public int insertFacil(Facility facil) {
		System.out.println("HsResServiceImpl insertFacil Start...");
		int result = hfd.insertFacil(facil);
		
		System.out.println("HsResServiceImpl insertFacil result-> "+result);
		System.out.println("HsResServiceImpl insertFacil insertFacil After...");
		return result;
	}

	@Override
	public int updateFac(Facility facil, int empno) {
		System.out.println("HsResServiceImpl updateFac Start...");
		int updateCount=0;
		updateCount = hfd.updateFac(facil);
		System.out.println("HsResServiceImpl updateFac updateCount -> "+updateCount);
		System.out.println("HsResServiceImpl updateFac After...");
		return updateCount;
	}

	@Override
	public List<Reservation> listappr(Reservation res, int empno) {
		List<Reservation> reserList = null;
		System.out.println("HsResServiceImpl listappr Start...");
		reserList = hrd.listfacil(res, empno);
		
		System.out.println("HsResServiceImpl listappr After...");
		return reserList;
	}

	@Override
	public int deleteFacil(int facilId, int empno) {
		System.out.println("HsResServiceImpl deleteFacil Start...");
		int result = 0;
		result = hfd.deleteFacil(facilId);
		System.out.println("HsResServiceImpl deleteFacil result-> "+result);
		
		System.out.println("HsResServiceImpl deleteFacil After...");
		return result;
	}

	@Override
	public int insertResRea(FacilApprove facAp, int empno) {
		System.out.println("HsResServiceImpl insertResRea Start...");
		int result = hrd.insertFacil(facAp, empno);
		
		System.out.println("HsResServiceImpl insertFacil result-> "+result);
		System.out.println("HsResServiceImpl insertResRea After...");
		return 0;
	}

	@Override
	public int updateResState(FacilApprove facAp, int empno) {
		System.out.println("HsResServiceImpl updateResState Start...");
		int updateCount = hrd.updateFac(facAp, empno);
		System.out.println("HsResServiceImpl updateFac updateCount -> "+updateCount);
		System.out.println("HsResServiceImpl updateResState After...");
		return 0;
	}
}
