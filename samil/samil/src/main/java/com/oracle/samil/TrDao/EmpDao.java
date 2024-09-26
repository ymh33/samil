package com.oracle.samil.TrDao;

import java.util.List;

import com.oracle.samil.Amodel.Dept;
import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.Amodel.EmpDept;
import com.oracle.samil.Amodel.LoginInfo;

public interface EmpDao {

	Emp findEmpbyEmpno(String empno);

	LoginInfo findPassbyQuiz(int passQuiz, String passAnswer, String empno);

	List<Dept> selectDeptList();

	int insertEmp(Emp emp);

	List<Emp> selectEmpList();

	List<EmpDept> selectEmpDeptList();

	EmpDept findEmpDept(String emp1empno);

	int updateEmp(Emp emp);

	List<EmpDept> searchByKeyword(String keyword);

	List<EmpDept> showDeptMember(int deptno);

	List<Emp> listdeptEmp(int deptno);
	
	

}
