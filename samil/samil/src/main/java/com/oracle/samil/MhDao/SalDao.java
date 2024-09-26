package com.oracle.samil.MhDao;

import java.util.List;

import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.Amodel.EmpSalDept;
import com.oracle.samil.Amodel.Sal;

public interface SalDao {


	int totalSal();

	List<EmpSalDept> totalEmp(EmpSalDept EmpSalDept);

	List<Sal> salDList(Sal sal);

	EmpSalDept shemp(EmpSalDept EmpSalDept);

	List<EmpSalDept> setTotalEmp(EmpSalDept EmpSalDept);

	List<EmpSalDept> empSearchList(EmpSalDept empSalDept);

	String findSalDate();

	int updateSal(int empno, int salBase, int salFood, int salBonus, int salNight, String account);


}
