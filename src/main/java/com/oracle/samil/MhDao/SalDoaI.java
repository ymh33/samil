package com.oracle.samil.MhDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.samil.Amodel.Emp;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SalDoaI implements SalDao {
	
	private final SqlSession session;

	@Override
	public int totalSal() {
		int totSalCount = 0;
		System.out.println("EmpDaoImpl Start totalEmp..." );
		
		try {
			totSalCount = session.selectOne("salTotal");
			System.out.println("EmpDaoImpl totalSal totEmpCount->" +totSalCount);
			
		} catch (Exception e) {
			System.out.println("EmpDaoImpl totalSal e.getMessage()->"+e.getMessage());
		}
		
		return totSalCount;
	
	}

	@Override
	public List<Emp> totalEmp(Emp emp) {
		List<Emp> totEmpCount  = null;
		System.out.println("EmpDaoImpl Start totalEmp..." );
		
		try {
			totEmpCount = session.selectList("empTotal", emp);
			System.out.println("EmpDaoImpl totalSal totEmpCount->" +totEmpCount);
			
		} catch (Exception e) {
			System.out.println("EmpDaoImpl totalSal e.getMessage()->"+e.getMessage());
		}
		
		return totEmpCount;
	}


}
