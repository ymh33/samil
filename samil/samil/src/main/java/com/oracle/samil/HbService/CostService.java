package com.oracle.samil.HbService;

import java.util.List;
import java.util.Map;

import com.oracle.samil.Amodel.Cost;
import com.oracle.samil.Amodel.CostCode;

public interface CostService {

	// 유저 cost 확인 관련
	List<Cost> 			getCostList(Cost cost);
	Cost                         addNewCost(Cost cost);
	List<Cost> 			searchCost(Cost cost);
	
	
	// 정산 코드 관련
	List<CostCode> getCodeList();
	int                             costCodeDel(int codeNum);
	CostCode             costCodePlus(CostCode costCode);
	
	// admin cost 확인 관려
	List<Cost>           getAdminCost(Cost cost);
	Cost                         detailCost(String costTitle);
	void 							updateCostStatus(String costTitle, int newStatus);


	

}
