package com.oracle.samil.HsDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.samil.Amodel.Facility;
import com.oracle.samil.Amodel.Reservation;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class HsFacilDaoImpl implements HsFacilDao {
	
	@Autowired
	private final SqlSession session;
	
	@Override
	public List<Facility> facilSortList() {
		List<Facility> facilSort = null;
		System.out.println("HsFacilDaoImpl facilSortList Start...");
		
		try {
			facilSort = session.selectList("tkFacilSort");
		} catch (Exception e) {
			System.out.println("HsFacilDaoImpl facilSortList e.getMessage()-> "+e.getMessage());
		}
		return facilSort;
	}

	@Override
	public List<Facility> listfacil(Facility facil) {
		List<Facility> facilSort = null;
		System.out.println("HsFacilDaoImpl listfacil Start...");
		
		try {
			facilSort = session.selectList("tkFacilSort");
		} catch (Exception e) {
			System.out.println("HsFacilDaoImpl listfacil e.getMessage()-> "+e.getMessage());
		}
		return facilSort;
	}

	@Override
	public Facility detailfacil(int facilId) {
		Facility facil = new Facility();
		System.out.println("HsFacilDaoImpl detailfacil Start...");
		try {
			facil = session.selectOne("tkFacSelOne", facilId);
			System.out.println("HsFacilDaoImpl detailfacil facil-> "+facil);
			
		} catch (Exception e) {
			System.out.println("HsFacilDaoImpl detailfacil e.getMessage()-> "+e.getMessage());
		}
		System.out.println("HsFacilDaoImpl detailfacil End...");
		return facil;
	}

	@Override
	public int insertFacil(Facility facil) {
		int result = 0;
		System.out.println("HsFacilDaoImpl insertFacil Start...");
		
		try {
			result = session.insert("tkFacilInsert", facil);
			System.out.println("HsFacilDaoImpl insertFacil facil-> "+facil);
		} catch (Exception e) {
			System.out.println("HsFacilDaoImpl insertFacil e.getMessage()-> "+e.getMessage());
		}
		return result;
	}

	@Override
	public int updateFac(Facility facil) {
		int updateCount = 0;
		System.out.println("HsFacilDaoImpl updateFac Start...");
		
		
		try {
			updateCount = session.update("tkupdateFacil", facil);
			System.out.println("HsFacilDaoImpl updateFac updateCount-> "+updateCount);
		} catch (Exception e) {
			System.out.println("HsFacilDaoImpl updateFac e.getMessage()-> "+e.getMessage());
		}
		return updateCount;
	}

	@Override
	public int deleteFacil(int facilId) {
		int result = 0;
		System.out.println("HsFacilDaoImpl deleteFacil Start...");
		System.out.println("HsFacilDaoImpl deleteFacil facilId->" +facilId);
		try {
			result = session.delete("tkFacilDelete", facilId);
			System.out.println("HsFacilDaoImpl deleteFacil result-> "+result);
		} catch (Exception e) {
			System.out.println("HsFacilDaoImpl deleteFacil e.getMessage()-> "+e.getMessage());
		}
		return result;
	}

}
