package com.oracle.samil.HsDao;

import java.util.List;

import com.oracle.samil.Amodel.Facility;

public interface HsFacilDao {

	List<Facility> facilSortList();
	List<Facility> listfacil(Facility facil);
	Facility 		detailfacil(int facilId);
	int 			insertFacil(Facility facil);
	int 			updateFac(Facility facil);
	int 			deleteFacil(int facilId);
	
}
