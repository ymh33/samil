package com.oracle.samil.TrService;

import java.util.List;

import com.oracle.samil.Amodel.Dept;
import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.Amodel.EmpDept;
import com.oracle.samil.Amodel.LoginInfo;

public interface EmpService {

	boolean validateUser(String empno, String password);

	Emp findEmpbyEmpno(String empno);

	LoginInfo findPassword(int passQuiz, String passAnswer, String empno);

	List<Dept> deptSelect();

	int insertEmp(Emp emp);

	List<Emp> empSelect();

	List<EmpDept> empdeptSelect();

	EmpDept findEmpDeptbyEmpno(String emp1empno);

	int updateEmp(Emp emp);

	List<EmpDept> searchByKeyword(String keyword);

	List<EmpDept> showDeptMember(int deptno);

	List<Emp> listdeptEmp(int deptno);


}
