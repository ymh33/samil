package com.oracle.samil.MhService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.MhDao.SalDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalServiceI implements SalService {
	private final SalDao sd;
	

	@Override
	public int totalSal() {
		System.out.println("EmpServiceImpl totalEmp Start ..." );
		int totSalCnt = sd.totalSal();
		System.out.println("EmpServiceImpl totalEmp totEmpCnt->" + totSalCnt);
		return totSalCnt;
	}


	@Override
	public List<Emp> totalEmp(Emp emp) {
		List<Emp> totSalCnt = null;
		System.out.println("EmpServiceImpl listManager start");
		totSalCnt = sd.totalEmp(emp);
		return totSalCnt;
	}

}
