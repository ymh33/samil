package com.oracle.samil.HbDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.samil.Amodel.Cost;
import com.oracle.samil.Amodel.CostCode;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class CostDaoImpl implements CostDao {
	
	@Autowired
	private final SqlSession session;
	
	@Override
	public List<Cost> costList(Cost cost) {
	    List<Cost> costList = null;
	    try {
	        costList = session.selectList("getCostList",cost); 
	        System.out.println("CostDaoImpl costList start...");
	    } catch (Exception e) {
	        System.out.println("CostDaoImpl error .. : " + e.getMessage());
	    }
	    return costList;
	}
	
	@Override
	public List<Cost> searchCost(Cost cost) {
		List <Cost> searchCost = null;
		try {
			searchCost = session.selectList("searchCost", cost);
			System.out.println("searchCost ==> " + (searchCost != null ? searchCost.size() : 0));
		} catch (Exception e) {
			System.out.println("CostDaoImpl searchCost error : " +e.getMessage());
		}
		return searchCost;
	}


	@Override
	public List<CostCode> costCodeList() {
		// CostCode와 Cost 조인 이후에 정보 가지고 오는 것
		List<CostCode> getcostCode = null;
		try {
			getcostCode = session.selectList("getcostCode",getcostCode);
			System.out.println("CostDaoImpl costCodeList start...");
		} catch (Exception e) {
			System.out.println("CostDaoImpl Code error .. : " + e.getMessage());
		}
		return getcostCode;
	}

	@Override
	public CostCode costCodePlus(CostCode costCode) {
		int costCodePlus = 0;
		try {
			costCodePlus = session.insert("costCodePlus", costCode);
		} catch (Exception e) {
			System.out.println("CostDaoImpl costCodePlus error .. : " + e.getMessage());
		}
		return costCode;
	}
	
	@Override
	public int costCodeDel(int codeNum) {
		System.out.println("CostDaoImpl Code delete Start...");
		int costDelCode = 0;
		try {
			costDelCode = session.delete("costCodeDel",codeNum);
			System.out.println("CostDaoImpl costCodeDel  start ");
		} catch (Exception e) {
			System.out.println("CostDaoImpl Code delete error .. : " + e.getMessage());
		}
		return costDelCode;
	}

	@Override
	public List<Cost> adminCostDao(Cost cost) {
		List<Cost> getAdminCost = null;
		try {
			getAdminCost = session.selectList("getAdminCost",cost);
			System.out.println("CostDaoImpl getAdminCost start...");
		} catch (Exception e) {
			System.out.println("CostDaoImpl getAdminCost error " +e.getMessage());
		}
		return getAdminCost;
	}

	@Override
	public int getMaxCodeNum() {
		int maxCodeNum;
		try {
			maxCodeNum = session.selectOne("getMaxCodeNum");
			return maxCodeNum;
		} catch (Exception e) {
			System.out.println("CostDaoImpl insertCost error " +e.getMessage());
			return 0;
		}
	}
	
	
	@Override
	public Cost addNewCost(Cost cost) {
	    try {
	        // 여기에 cost 객체의 필드를 설정해야 합니다.
	        // 예시: cost.setEmpno(...) 등
	        int costResult = session.insert("insertCost", cost);
	        
	        if (costResult > 0) {
	            System.out.println("Insertion successful");
	        } else {
	            System.out.println("Insertion failed");
	        }
	    } catch (Exception e) {
	        System.out.println("CostDaoImpl insertCost error " + e.getMessage());
	        e.printStackTrace();
	    }
	    return cost; // 수정된 cost 객체 반환
	}

	@Override
	public String getCodeNameByCodeNum(int codeNum) {
        return session.selectOne("getCodeNameByCodeNum", codeNum);
	}

	@Override
	public Cost detailCost(String costTitle) {
		Cost cost = new Cost();
		cost.setCostTitle(costTitle);
		System.out.println("CostDao detailCost start...");
		try {
			cost = session.selectOne("getcostDetail",cost);
			System.out.println("CostDao detailCost costTitle..." + cost.getCostTitle());
		} catch (Exception e) {
			System.out.println("CostDaoImpl detailCost error " + e.getMessage());
		}
		
		return cost;
	}
	

	    @Override
	    public void updateStatus(String costTitle, int newStatus) {
	        Map<String, Object> updateStatus = new HashMap<>();
	        updateStatus.put("costTitle", costTitle);
	        updateStatus.put("newStatus", newStatus);
	        session.update("updateStatus", updateStatus);
	    }
	}

