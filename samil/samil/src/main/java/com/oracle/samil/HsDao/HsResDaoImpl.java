package com.oracle.samil.HsDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.samil.Amodel.Event;
import com.oracle.samil.Amodel.FacilApprove;
import com.oracle.samil.Amodel.Reservation;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class HsResDaoImpl implements HsResDao {
	
	@Autowired
	private final SqlSession session;

	@Override
	public List<Reservation> listload(Reservation res, int empno) {
		List<Reservation> listload = null;
		System.out.println("HsResDaoImpl listload Start...");
		
		Map<String, Object> resm = new HashMap<>();
		resm.put("res", res);
		resm.put("empno", empno);
		try {
			listload = session.selectList("tkResListLoad",resm);
			System.out.println("HsResDaoImpl listload listload.size()-> "+listload.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsResDaoImpl listload e.getMessage()-> "+e.getMessage());
		}
		
		System.out.println("HsResDaoImpl listload End...");
		return listload;
	}

	@Override
	public List<FacilApprove> listFacilAcc(FacilApprove faAp, int empno) {
		List<FacilApprove> listFacilAcc = null;
		System.out.println("HsResDaoImpl listFacilAcc Start...");
		
		Map<String, Object> faAp1 = new HashMap<>();
		faAp1.put("faAp", faAp);
		faAp1.put("empno", empno);
		try {
			listFacilAcc = session.selectList("tkResListAcc",faAp1);
			System.out.println("HsResDaoImpl listFacilAcc listload.size()-> "+listFacilAcc.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsResDaoImpl listFacilAcc e.getMessage()-> "+e.getMessage());
		}
		
		System.out.println("HsResDaoImpl listFacilAcc End...");
		return listFacilAcc;
	}

	@Override
	public List<FacilApprove> listFacilRej(FacilApprove faAp, int empno) {
		List<FacilApprove> listFacilRej = null;
		System.out.println("HsResDaoImpl listFacilRej Start...");
		
		Map<String, Object> faAp1 = new HashMap<>();
		faAp1.put("faAp", faAp);
		faAp1.put("empno", empno);
		try {
			listFacilRej = session.selectList("tkResListRej",faAp1);
			System.out.println("HsResDaoImpl listFacilRej listFacilRej.size()-> "+listFacilRej.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsResDaoImpl listFacilRej e.getMessage()-> "+e.getMessage());
		}
		
		System.out.println("HsResDaoImpl listFacilRej End...");
		return listFacilRej;
	}

	@Override
	public int insertReserv(Reservation res, int empno) {
		int result = 0;
		System.out.println("HsResDaoImpl insertReserv Start...");
		
		try {
			result = session.insert("tkReserInsert", res);
			System.out.println("HsResDaoImpl insertReserv res-> "+res);
		} catch (Exception e) {
			System.out.println("HsResDaoImpl insertReserv e.getMessage()-> "+e.getMessage());
		}
		return result;
	}

	@Override
	public int updateReserv(Reservation res, int empno) {
		int updateCount = 0;
		System.out.println("HsResDaoImpl updateReserv Start...");
		
		
		try {
			updateCount = session.update("tkupdateReserv", res);
			System.out.println("HsResDaoImpl updateReserv updateCount-> "+updateCount);
		} catch (Exception e) {
			System.out.println("HsResDaoImpl updateReserv e.getMessage()-> "+e.getMessage());
		}
		return updateCount;
	}

	@Override
	public Reservation detailRes(int resCode, int empno) {
		Reservation res = new Reservation();
		System.out.println("HsResDaoImpl detailRes Start...");
		try {
			res = session.selectOne("tkResSelOne", resCode);
			System.out.println("HsResDaoImpl detailRes event-> "+res);
			
		} catch (Exception e) {
			System.out.println("HsResDaoImpl detailRes e.getMessage()-> "+e.getMessage());
		}
		System.out.println("HsResDaoImpl detailRes End...");
		return res;
	}

	@Override
	public int deleteRes(int resCode, int empno) {
		int result = 0;
		System.out.println("HsResDaoImpl deleteRes Start...");
		System.out.println("HsResDaoImpl deleteRes resCode->" +resCode);
		try {
			result = session.delete("tkResDelete", resCode);
			System.out.println("HsResDaoImpl deleteRes result-> "+result);
		} catch (Exception e) {
			System.out.println("HsResDaoImpl deleteRes e.getMessage()-> "+e.getMessage());
		}
		return result;
	}

	@Override
	public List<Reservation> listfacil(Reservation res, int empno) {
		List<Reservation> reserList = null;
		System.out.println("HsResDaoImpl listfacil Start...");
		
		Map<String, Object> resm = new HashMap<>();
		resm.put("res", res);
		resm.put("empno", empno);
		try {
			reserList = session.selectList("tkResListAppr",resm);
			System.out.println("HsResDaoImpl listfacil reserList.size()-> "+reserList.size());
		} catch (Exception e) {
			System.out.println("HsResDaoImpl listfacil e.getMessage()-> "+e.getMessage());
		}
		
		System.out.println("HsResDaoImpl listfacil End...");
		return reserList;
	}

	@Override
	public int insertFacil(FacilApprove facAp, int empno) {
		int result = 0;
		System.out.println("HsResDaoImpl insertFacil Start...");
		
		try {
			result = session.insert("tkResAppInsert", facAp);
			System.out.println("HsResDaoImpl insertFacil res-> "+facAp);
		} catch (Exception e) {
			System.out.println("HsResDaoImpl insertFacil e.getMessage()-> "+e.getMessage());
		}
		return result;
	}

	@Override
	public int updateFac(FacilApprove facAp, int empno) {
		int updateCount = 0;
		System.out.println("HsResDaoImpl updateFac Start...");
		
		try {
			updateCount = session.update("tkupdateResApp", facAp);
			System.out.println("HsResDaoImpl updateFac updateCount-> "+updateCount);
		} catch (Exception e) {
			System.out.println("HsResDaoImpl updateFac e.getMessage()-> "+e.getMessage());
		}
		return updateCount;
	}


}
