package com.oracle.samil.MhDao;

import java.util.List;

import com.oracle.samil.Amodel.Emp;

public interface SalDao {

	int totalSal();

	List<Emp> totalEmp(Emp emp);


}
