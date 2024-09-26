package com.oracle.samil.MhDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.Amodel.EmpSalDept;
import com.oracle.samil.Amodel.Sal;
import com.oracle.samil.MhService.Paging;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SalDoaI implements SalDao {

	@Autowired
	private final SqlSession session;

	@Override
	public int totalSal() {
		int totSalCount = 0;
		
		try {
			totSalCount = session.selectOne("salTotal");
			
		} catch (Exception e) {
			System.out.println("EmpDaoImpl totalSal e.getMessage()->"+e.getMessage());
		}
		
		return totSalCount;
	
	}

	@Override
	public List<EmpSalDept> totalEmp(EmpSalDept EmpSalDept) {
		List<EmpSalDept> totEmpCount  = null;
		
		try {
			totEmpCount = session.selectList("empTotal", EmpSalDept);
		} catch (Exception e) {
		}
		
		return totEmpCount;
	}

	@Override
	public List<Sal> salDList(Sal sal) {
		List<Sal> salDList = null;
		
		try {
			salDList = session.selectList("salDList", sal);
			
		} catch (Exception e) {
			
		}
		return salDList;
	}

	@Override
	public EmpSalDept shemp(EmpSalDept EmpSalDept) {
		EmpSalDept shemp = null;
		
		try {
			shemp = session.selectOne("shemp", EmpSalDept);
			
		} catch (Exception e) {
			System.out.println("error"+e.getMessage());
			
		}
		
		return shemp;
	}

	@Override
	public List<EmpSalDept> setTotalEmp(EmpSalDept EmpSalDept) {
		List<EmpSalDept> setTotalEmp = null;
		
		try {
			setTotalEmp = session.selectList("setTotalEmp", EmpSalDept);
			
		} catch (Exception e) {
			
		}
		return setTotalEmp;
	}

	@Override
	public List<EmpSalDept> empSearchList(EmpSalDept empSalDept) {
		List<EmpSalDept> empSearchList = null;
		try {
			empSearchList = session.selectList("EmpSearchList",empSalDept);
			System.out.println("Dao listSearch3 listSearchEmp.size()=>" + empSearchList.size());
			System.out.println("Dao listSearch3 empSearchList=>" + empSearchList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return empSearchList;
	}

	@Override
	public String findSalDate() {
		String findSalDate = null;
		try {
			findSalDate = session.selectOne("findSalDate");
			System.out.println("dao salDate->" +findSalDate);
			
		}catch (Exception e) {
			System.out.println("EmpDaoImpl findSalDate e.getMessage()->"+e.getMessage());
		}
		
		return findSalDate;
	}



}
