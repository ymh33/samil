package com.oracle.samil.MhService;

import java.util.List;
import java.util.Map;

import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.Amodel.EmpSalDept;
import com.oracle.samil.Amodel.Sal;

public interface SalService {

	int totalSal();

	List<EmpSalDept> totalEmp(EmpSalDept EmpSalDept);

	List<Sal> salDList(Sal sal);

	EmpSalDept shemp(EmpSalDept EmpSalDept);

	List<EmpSalDept> setTotalEmp(EmpSalDept EmpSalDept);

	List<EmpSalDept> listSearchEmp(EmpSalDept empSalDept);

	String getSalDate();

	int updateSal(int empno, int salBase, int salFood, int salBonus, int salNight, String account);

}
