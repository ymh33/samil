package com.oracle.samil.HbService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.samil.Amodel.Cost;
import com.oracle.samil.Amodel.CostCode;
import com.oracle.samil.HbDao.CostDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CostServiceImpl implements CostService {
	
	@Autowired
	private final CostDao hbCostDao;
	
	@Override
	public List<Cost> getCostList(Cost cost) {
		System.out.println("HbcostList getCostList start...");
		List<Cost> costList = hbCostDao.costList(cost);
		System.out.println("hbCostList getCostList cost size.. = >  " + costList.size());
		return costList;
	}
	
	@Override
	public List<CostCode> getCodeList() {
		System.out.println("Hbcostservice getCodeList start...");
		List<CostCode> getCostCodeList = hbCostDao.costCodeList();
		System.out.println("hbCostService getCostCodeList size = > " + getCostCodeList.size());
		return getCostCodeList;
	}

	@Override
	public List<Cost> searchCost(Cost cost) {
		System.out.println("HBcostService searchCost start... ");
		List<Cost> searchCostList = hbCostDao.searchCost(cost);
		if (searchCostList != null) {
			System.out.println("HbcostService searchCostList size = > " + searchCostList.size());
		} else {
			System.out.println("No results found.");
		}
		return searchCostList;
	}
	
	@Override
	public CostCode costCodePlus(CostCode costCode) {
		    System.out.println("HbcostService CostCodePlus start...");

		    // 최대 codeNum 조회
		    int maxCodeNum = hbCostDao.getMaxCodeNum();
		    if (maxCodeNum == 0l) {
		        maxCodeNum = 180; // 초기값 설정
		    } else {
		        maxCodeNum += 10; // 10씩 증가
		    }

		    costCode.setCodeNum(maxCodeNum); // 새로운 codeNum 설정
		    return hbCostDao.costCodePlus(costCode); // DAO 호출
		}
	
	@Override
	public int costCodeDel(int codeNum) {
		System.out.println("Hbcostservice costCodeDel start...");
		int costDelCode = hbCostDao.costCodeDel(codeNum);
		System.out.println("Hbcostservice costCodeDel =" + codeNum);
		return costDelCode;
	}

	@Override
	public List<Cost> getAdminCost(Cost cost) {
		List<Cost> adminCostList = hbCostDao.adminCostDao(cost);
		System.out.println("HbcostService getAdminCost start...");
		System.out.println("HbcostService getAdminCost size = > " +adminCostList.size());
		return adminCostList;
	}

	@Override
	public Cost addNewCost(Cost cost) {
	    try {
	        // codeNum에 따라 codeName 조회
	        String codeName = hbCostDao.getCodeNameByCodeNum(cost.getCodeNum());
	        cost.setCodeName(codeName); // Cost 객체에 codeName 설정
			cost.setStatus(100);
			cost.setEmpno(1005);
			cost.setDeptno("104");
			cost.setStatus(100);
	        // Cost 삽입
	        hbCostDao.addNewCost(cost);
	        System.out.println("정보 확인 :   " +  cost.getAttach()+ " / " + cost.getCodeName() + " / " + cost.getCostTitle() + " / " + cost.getCostMoney() + " / " + cost.getEmpno() + " / " + cost.getSigndate()+ " / " + cost.getCostYear() + " / " + cost.getStatus());
	        
	        System.out.println("삽입 성공");
	    } catch (Exception e) {
	        System.out.println("CostDaoImpl insertCost 오류: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return cost; // 수정된 Cost 객체 반환
	}

	@Override
	public Cost detailCost(String costTitle) {
		   System.out.println("HbService detailCost start...");
		   Cost costDetail = hbCostDao.detailCost(costTitle);
			return costDetail;
	}

	 @Override
	    public void updateCostStatus(String costTitle, int newStatus) {
	        hbCostDao.updateStatus(costTitle, newStatus);
	    }
	


		
	}
