package com.oracle.samil.TrDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.samil.Amodel.Dept;
import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.Amodel.EmpDept;
import com.oracle.samil.Amodel.LoginInfo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmpDaoImpl implements EmpDao {

	private final SqlSession session;

	@Override
	public Emp findEmpbyEmpno(String empno) {
		System.out.println("asd" + empno);
		System.out.println("findEmpbyEmpno start..");
		Emp emp = new Emp();
		try {
			System.out.println("findEmpbyEmpno ->" + empno);
			emp = session.selectOne("trEmpSelect", empno);

		} catch (Exception e) {
			System.out.println(" findEmpbyEmpno->" + e.getMessage());
		}
		return emp;
	}

	@Override
	public LoginInfo findPassbyQuiz(int passQuiz, String passAnswer, String empno) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setPassAnswer(passAnswer);
		loginInfo.setPassQuiz(passQuiz);
		loginInfo.setEmpno(Integer.parseInt(empno));
		System.out.println("EmpDao impl findPassbyQuiz->" + passAnswer);
		try {
			loginInfo = session.selectOne("trFindPass", loginInfo);
		} catch (Exception e) {
			System.out.println("EmpDao impl findPassbyQuiz->" + e.getMessage());
		}

		return loginInfo;
	}

	@Override
	public List<Dept> selectDeptList() {
		List<Dept> deptList = null;
		System.out.println("DeptDaoImpl deptSelect Start...");
		try {
			deptList = session.selectList("trSelectDept");
		} catch (Exception e) {
			System.out.println("DeptDaoImpl deptSelect Exception->" + e.getMessage());
		}
		return deptList;
	}

	@Override
	public int insertEmp(Emp emp) {
		int result = 0;
		System.out.println("EmpDaoImpl insert Start...");
		try {
			result = session.insert("trInsertEmp", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl insert Exception->" + e.getMessage());
		}
		return result;
	}

	@Override
	public List<Emp> selectEmpList() {
		List<Emp> empList = null;
		System.out.println("DeptDaoImpl empSelect Start...");
		try {
			empList = session.selectList("trSelectEmp");
		} catch (Exception e) {
			System.out.println("DeptDaoImpl empSelect Exception->" + e.getMessage());
		}
		return empList;
	}

	@Override
	public List<EmpDept> selectEmpDeptList() {
		List<EmpDept> empDeptList = null;
		System.out.println("DeptDaoImpl empDeptSelect Start...");
		try {
			empDeptList = session.selectList("trSelectEmpDept");
		} catch (Exception e) {
			System.out.println("DeptDaoImpl empDeptSelect Exception->" + e.getMessage());
		}
		return empDeptList;
	}

	@Override
	public EmpDept findEmpDept(String emp1empno) {
		EmpDept empDept = null;
		try {
			empDept=session.selectOne("trFindEmpDept",emp1empno);
		} catch (Exception e) {
			System.out.println("findEmpDept->"+e.getMessage());
		}
		
		return empDept;
	}

	@Override
	public int updateEmp(Emp emp) {
		int result = 0;
		System.out.println("EmpDaoImpl update Start...");
		try {
			result = session.update("trUpdateEmp", emp);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl update Exception->" + e.getMessage());
		}
		return result;
	}

	@Override
	public List<EmpDept> searchByKeyword(String keyword) {
		List<EmpDept> empDeptList = null;
		System.out.println("searchByKeywort Start..."+keyword);
		try {
			empDeptList = session.selectList("trSearchEmpByKeyword", keyword );
		} catch (Exception e) {
			System.out.println("EmpDaoImpl searchByKeywor Exception->" + e.getMessage());
		}
		return empDeptList;
	}

	@Override
	public List<EmpDept> showDeptMember(int deptno) {
		List<EmpDept> empDeptList = null;
		System.out.println("showDeptMember Start..."+deptno);
		try {
			empDeptList = session.selectList("trShowDeptMember", deptno);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl searchByKeywor Exception->" + e.getMessage());
		}
		return empDeptList;
	}


	@Override
	public List<Emp> listdeptEmp(int deptno) {
		List<Emp> empDeptlist = null;
		System.out.println("EmpDaoImpl listdeptEmp Start...");

		try {
			empDeptlist = session.selectList("tkEmpDeptListAll",deptno);
			System.out.println("EmpDaoImpl listdeptEmp empDeptlist.size()-> "+empDeptlist.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EmpDaoImpl listdeptEmp e.getMessage()-> "+e.getMessage());
		}
		return empDeptlist;
	}
}
