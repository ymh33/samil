package com.oracle.samil.MhService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.Amodel.EmpSalDept;
import com.oracle.samil.Amodel.Sal;
import com.oracle.samil.MhDao.SalDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalServiceI implements SalService {

	@Autowired
	private final SalDao sd;
	

	@Override
	public int totalSal() {
		int totSalCnt = sd.totalSal();
		return totSalCnt;
	}


	@Override
	public List<EmpSalDept> totalEmp(EmpSalDept EmpSalDept) {
		List<EmpSalDept> totSalCnt = null;
		totSalCnt = sd.totalEmp(EmpSalDept);
		return totSalCnt;
	}


	@Override
	public List<Sal> salDList(Sal sal) {
		List<Sal> salDList = null;
		salDList = sd.salDList(sal);
		return salDList;
	}

	@Override
	public EmpSalDept shemp(EmpSalDept EmpSalDept) {
		EmpSalDept shemp = null;
		shemp = sd.shemp(EmpSalDept);

		return shemp;
	}


	@Override
	public List<EmpSalDept> setTotalEmp(EmpSalDept EmpSalDept) {
		List<EmpSalDept>setTotalEmp =null;
		setTotalEmp = sd.setTotalEmp(EmpSalDept);
		return setTotalEmp;
	}


	@Override
	public List<EmpSalDept> listSearchEmp(EmpSalDept empSalDept) {
			List<EmpSalDept> listSearchEmp = null;
			listSearchEmp = sd.empSearchList(empSalDept);
			System.out.println("Service listSearch3 listSearchEmp.size()=>" + listSearchEmp.size());
			
			return listSearchEmp;
		}


	@Override
	public String getSalDate() {
		String getSalDate =  sd.findSalDate();
		System.out.println("service salDate->" +getSalDate);
		return getSalDate;
	}


	@Override
	public int updateSal(int empno, int salBase, int salFood, int salBonus, int salNight, String account) {
		int salupdate = sd.updateSal(empno,salBase, salFood, salBonus, salNight, account);
		
		System.out.println("salupdate service->" +salupdate);
		System.out.println("salupdate service empno->" +empno);
		System.out.println("salupdate service salbase->" +salBase);
		
		return salupdate;
		
	}



}
