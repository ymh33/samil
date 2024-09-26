package com.oracle.samil.HbDao;

import java.util.List;

import com.oracle.samil.Amodel.Cost;
import com.oracle.samil.Amodel.CostCode;

public interface CostDao {

	
	List<Cost> 		    costList(Cost cost);
	String                      getCodeNameByCodeNum(int codeNum);
	Cost                          addNewCost(Cost cost);
	List<Cost> 			searchCost(Cost cost);
	
	
	// costCode 추가 삭제 method
	List<CostCode> costCodeList();
	int                             getMaxCodeNum();
	int                              costCodeDel(int codeNum);
	CostCode              costCodePlus(CostCode costCode);
	
	//  관리자 cost
	List<Cost>            adminCostDao(Cost cost);
	Cost                          detailCost(String costTitle);
	void							 updateStatus(String costTitle, int newStatus);



}
