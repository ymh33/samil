package com.oracle.samil.Acontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.oracle.samil.Amodel.Dept;
import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.Amodel.EmpDept;
import com.oracle.samil.Amodel.LoginInfo;
import com.oracle.samil.TrService.EmpService;

import jakarta.servlet.http.HttpServletRequest;






@Controller
@RequestMapping(value="/tr")
public class TrEmpController {
	
	@Autowired
	private EmpService es;
	
	@GetMapping(value = "/findPassword")
	public String findPassword (){
		System.out.println("tr infdPasswordplay~");
		return "tr/findPassword";
	}
	

	@GetMapping(value = "/findPasswordCheck")
	public String findPasswordCheck (@RequestParam("passQuiz") int passQuiz,@RequestParam("passAnswer")  String passAnswer,@RequestParam("empno")  String empno , Model model){
		System.out.println("tr infdPasswordCheckplay~");
		LoginInfo loginInfo =es.findPassword(passQuiz, passAnswer, empno);
		model.addAttribute("LoginInfo",loginInfo);
		return "tr/showPassword";
	}
	
	@PostMapping(value = "/addEmp")
	public String addEmp (HttpServletRequest request){
		Emp emp= new Emp();
		emp.setName(request.getParameter("name"));
		System.out.println("tr addEmp play~"+1);
		emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
		System.out.println("tr addEmp play~"+2);
		String email=request.getParameter("email1")+"@"+request.getParameter("email2");
		System.out.println("tr addEmp play~"+email);
		emp.setEmail(email);
		System.out.println("tr addEmp play~"+3);
		emp.setPhone(request.getParameter("phone"));
		emp.setGrade(Integer.parseInt(request.getParameter("grade")));
		System.out.println("tr addEmp play~"+4);
		emp.setJob(Integer.parseInt(request.getParameter("job")));
		System.out.println("tr addEmp play~"+5);
		emp.setBank(request.getParameter("bank"));
		System.out.println("tr addEmp play~"+6);
		emp.setAccount(request.getParameter("account"));
		System.out.println("tr addEmp play~"+7);
		emp.setAddress(request.getParameter("address"));
		System.out.println("tr addEmp play~"+8);
		emp.setHiredate(request.getParameter("hiredate"));
		System.out.println("tr addEmp play~"+request.getParameter("deptno"));
		emp.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		System.out.println("tr addEmp play~"+10);
		emp.setAdmin(0);
		System.out.println("tr addEmp play~");
		emp.setRecentEditor(1001);
		System.out.println("tr addEmp play~"+12);
		LocalDateTime now = LocalDateTime.now();
		String nowString= now.toString();
		System.out.println(nowString);
		emp.setRecentEditDate(nowString);
		System.out.println("tr addEmp play~"+13);
		System.out.println("tr addEmp play~"+emp.getEmpno());
		int insertResult = es.insertEmp(emp);
		return "tr/adminEmpList";
	}
	
	@GetMapping(value = "/empSearch")
	public String per_search (Model model){
		System.out.println("tr per_search play~");
		List<EmpDept> empdeptlist=es.empdeptSelect();
		model.addAttribute("empDeptList",empdeptlist);
		return "tr/empSearch";
	}
	
	@GetMapping(value = "/searchEmpByKeyword")
	public String searchEmpByKeyword (Model model, @RequestParam("keyword") String keyword){
		System.out.println("tr serchByKeyword~");
		List<EmpDept> empdeptlist=es.searchByKeyword(keyword);
		model.addAttribute("empDeptList",empdeptlist);
		return "tr/empSearch";
	}
	@GetMapping(value = "/searchEmpByKeyword_admin")
	public String searchEmpByKeyword_admin (Model model, @RequestParam("keyword") String keyword){
		System.out.println("tr serchByKeyword~");
		List<EmpDept> empdeptlist=es.searchByKeyword(keyword);
		model.addAttribute("empDeptList",empdeptlist);
		return "tr/adminEmpList";
	}
	
	@PostMapping(value = "/updateEmp")
	public String updateEmp (HttpServletRequest request, Model model){
		Emp emp= new Emp();
		emp.setName(request.getParameter("name"));
		System.out.println("tr addEmp play~"+1);
		emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
		System.out.println("tr addEmp play~"+2);
//		String email=request.getParameter("email1")+"@"+request.getParameter("email2");
//		System.out.println("tr addEmp play~"+email);
//		emp.setEmail(email);
		System.out.println("tr addEmp play~"+3);
		emp.setPhone(request.getParameter("phone"));
		emp.setGrade(Integer.parseInt(request.getParameter("grade")));
		System.out.println("tr addEmp play~"+4);
		emp.setJob(Integer.parseInt(request.getParameter("job")));
		System.out.println("tr addEmp play~"+5);
		emp.setBank(request.getParameter("bank"));
		System.out.println("tr addEmp play~"+6);
		emp.setAccount(request.getParameter("account"));
		System.out.println("tr addEmp play~"+7);
		emp.setAddress(request.getParameter("address"));
		System.out.println("tr addEmp play~"+request.getParameter("deptno"));
		emp.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		System.out.println("tr addEmp play~"+10);
		emp.setAdmin(0);
		System.out.println("tr addEmp play~");	
		emp.setRecentEditor(Integer.parseInt(request.getParameter("recentEditor")));
		System.out.println("tr addEmp play~"+12);
		LocalDateTime now = LocalDateTime.now();
		String nowString= now.toString();
		System.out.println(nowString);
		emp.setRecentEditDate(nowString);
		System.out.println("tr addEmp play~"+emp.getEmpno());
		emp.setAdmin(Integer.parseInt(request.getParameter("admin")));
		System.out.println("tr set Admin"+request.getParameter("admin"));
		int insertResult = es.updateEmp(emp);
		List<EmpDept> empdeptlist=es.empdeptSelect();
		model.addAttribute("empDeptList",empdeptlist);
		return "tr/adminEmpList";
	}
		
	@GetMapping(value = "/userGroupChart")
	public String per_check (Model model){
		System.out.println("tr per_check play~");
		List<Dept> deptlist= es.deptSelect();
		model.addAttribute("deptList",deptlist);
		return "tr/userGroupChart";
	}
	
	@GetMapping(value = "/adminEmpInsert")
	public String admin_per_inform (Model model){
		System.out.println("tr admin_per_inform play~");
		List<Dept> deptlist= es.deptSelect();
		model.addAttribute("deptList",deptlist);
		return "tr/adminEmpInsert";
	}
	
	@GetMapping(value = "/adminEmpList")
	public String admin_per_manage (Model model){
		System.out.println("tr admin_per_manage play~");
		List<EmpDept> empdeptlist=es.empdeptSelect();
		model.addAttribute("empDeptList",empdeptlist);
		return "tr/adminEmpList";
	}
	
	@GetMapping(value = "editEmpData")
	public String adminEditData (@RequestParam("empno") String  empno,Model model){

		System.out.println(" editEmpData empno->"+empno);
		EmpDept empdept= es.findEmpDeptbyEmpno(empno);
		List<Dept> deptlist= es.deptSelect();
		model.addAttribute("deptList",deptlist);
		model.addAttribute("emp1",empdept);
		return "tr/editEmpData";
	}
	
	@GetMapping(value = "showDeptMember")
	public String showDeptMember (@RequestParam("deptno") int  deptno,Model model){

		System.out.println(" showDeptMember->"+deptno);
		List<EmpDept> empDeptlist= es.showDeptMember(deptno);
		model.addAttribute("empDeptList",empDeptlist);
		return "tr/empSearch";
	}
	
	@GetMapping(value = "/adminGroupChart")
	public String admin_group_check (Model model){
		System.out.println("tr admin_group_check play~");
		List<Dept> deptlist= es.deptSelect();
		model.addAttribute("deptList",deptlist);
		return "tr/adminGroupChart";
	}
	
	
}
