package com.oracle.samil.Acontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.Amodel.EmpSalDept;
import com.oracle.samil.Amodel.Sal;
import com.oracle.samil.MhService.Paging;
import com.oracle.samil.MhService.SalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/mh")
public class MhSalController {

	@Autowired
	private final SalService ss;
		
		@GetMapping(value = "/salJoin")
		public String sal_join (){
			System.out.println("mh sal_join play~");
			return "mh/salJoin";
		}

		@GetMapping(value = "/adminSalSet")
		public String empList (EmpSalDept EmpSalDept, Model model){
			int totalSal =  ss.totalSal();
			String currentPage = "1";
			
			Paging page = new Paging(totalSal, EmpSalDept.getCurrentPage());
			EmpSalDept.setStart(page.getStart());
			EmpSalDept.setEnd(page.getEnd());
			String salDate = ss.getSalDate();
			System.out.println("page.getEnd()1 ->"+ page.getEnd());


			System.out.println("Sal->" + totalSal);
			List<EmpSalDept> listEmp = ss.totalEmp(EmpSalDept);
			model.addAttribute("totalSal", totalSal);
			model.addAttribute("listEmp", listEmp);
			model.addAttribute("page", page);
			model.addAttribute("salDate", salDate);
			System.out.println("controller salDate->" +salDate);
			
			return "/mh/adminSalSet";
			
		}
		@ResponseBody
	    @GetMapping("/getDeptName")
		  public ResponseEntity<Map<String, EmpSalDept>> getDeptName(@RequestParam("empno") int empno) {
			EmpSalDept EmpSalDept = new EmpSalDept();
			EmpSalDept.setEmpno(empno);
			EmpSalDept shemp = ss.shemp(EmpSalDept);
			Map<String, EmpSalDept> response = new HashMap<>();
			response.put("response", shemp);
			
	        return ResponseEntity.ok(response); 
		}
		
		@RequestMapping(value = "listSearch")
		public String listSearch(EmpSalDept empSalDept ,  Model model) {
			System.out.println("EmpController Start listEmp..." );
			System.out.println("EmpController listSearch empSalDept->"+empSalDept );
			// Emp 전체 Count   
			int totalEmp =  ss.totalSal();
			// Paging 작업
			Paging   page = new Paging(totalEmp, empSalDept.getCurrentPage());
			// Parameter emp --> Page만 추가 Setting
			empSalDept.setStart(page.getStart());   // 시작시 1
			empSalDept.setEnd(page.getEnd());       // 시작시 10 
			String salDate = ss.getSalDate();
			List<EmpSalDept> listSearchEmp = ss.listSearchEmp(empSalDept);
			// 1. DAO  ed.empSearchList3(emp);
	        // 2. Mapper selectList("tkEmpSearchList3", emp);

			System.out.println("EmpController listSearch3 listSearchEmp.size()=>" + listSearchEmp.size());
			model.addAttribute("salDate", salDate);
			model.addAttribute("totalEmp", totalEmp);
			model.addAttribute("listEmp" , listSearchEmp);
			model.addAttribute("page"    , page);
			return "mh/adminSalSet";
		}
		
		@RequestMapping(value = "/listSearchGive")
		public String listSearchGive(EmpSalDept empSalDept ,  Model model) {
			System.out.println("EmpController Start listEmp..." );
			System.out.println("EmpController listSearch empSalDept->"+empSalDept );
			// Emp 전체 Count   
			int totalEmp =  ss.totalSal();
			// Paging 작업
			Paging   page = new Paging(totalEmp, empSalDept.getCurrentPage());
			// Parameter emp --> Page만 추가 Setting
			empSalDept.setStart(page.getStart());   // 시작시 1
			empSalDept.setEnd(page.getEnd());       // 시작시 10 

			List<EmpSalDept> listSearchEmp = ss.listSearchEmp(empSalDept);
			// 1. DAO  ed.empSearchList3(emp);
	        // 2. Mapper selectList("tkEmpSearchList3", emp);

			System.out.println("EmpController listSearch3 listSearchEmp.size()=>" + listSearchEmp.size());
			
			model.addAttribute("totalEmp", totalEmp);
			model.addAttribute("listEmp" , listSearchEmp);
			model.addAttribute("page"    , page);
			return "mh/adminSalGive";
		}
		
		@ResponseBody
		@GetMapping("/loadEmployeeData")
		public ResponseEntity<Map<String, Object>> getEmployeeList(@RequestParam("currentPage") int currentPage) {
			int totalCount = ss.totalSal();
			int pageBlock = 10;
			int totalPage = (int)Math.ceil((double)totalCount/pageBlock);
			Paging page = new Paging(currentPage, totalPage, pageBlock);
			EmpSalDept EmpSalDept = new EmpSalDept();
			EmpSalDept.setStart(page.getStart());
			EmpSalDept.setEnd(page.getEnd());
			List<EmpSalDept> listemp = ss.totalEmp(EmpSalDept);
			System.out.println("controller listemp->"+listemp);
			Map<String, Object> resultMap = new HashMap<>();
			System.out.println("page.getEnd()2 ->"+ page.getEnd());
			resultMap.put("listEmp", listemp);
			resultMap.put("page", page);
			return new ResponseEntity<>(resultMap, HttpStatus.OK);
		}
		
		
		@GetMapping(value = "/adminSalGive")
		public String admin_sal_give (EmpSalDept empSalDept, Model model){
			int totalSal =  ss.totalSal();
			String currentPage = "1";
			String salDate = ss.getSalDate();
			
			Paging page = new Paging(totalSal, empSalDept.getCurrentPage());
			empSalDept.setStart(page.getStart());
			empSalDept.setEnd(page.getEnd());
			
			System.out.println("page.getEnd()1 ->"+ page.getEnd());


			System.out.println("Sal->" + totalSal);
			List<EmpSalDept> listEmp = ss.totalEmp(empSalDept);
			model.addAttribute("totalSal", totalSal);
			model.addAttribute("listEmp", listEmp);
			model.addAttribute("page", page);
			model.addAttribute("salDate", salDate);
			return "mh/adminSalGive";
		}
		
		
		@GetMapping(value = "/adminSalSetUpdate")
		public String sal_setUpdate (@RequestParam("empno") int empno, Model model){
			System.out.println("mh sal_setUpdate play~");
			System.out.println("empno->" +empno);
			EmpSalDept EmpSalDept = new EmpSalDept();
			EmpSalDept.setEmpno(empno);
			EmpSalDept shemp = ss.shemp(EmpSalDept);
			System.out.println("shemp->"+shemp);
			model.addAttribute("shemp", shemp);
			return "mh/adminSalSetUpdate";
		}
		
		@GetMapping(value = "/adminSalGiveD")
		public String sal_give_D (@RequestParam("empno") int empno, Model model){
			EmpSalDept EmpSalDept = new EmpSalDept();
			String salDate = ss.getSalDate();
			EmpSalDept.setEmpno(empno);
			EmpSalDept shemp = ss.shemp(EmpSalDept);
			System.out.println("shemp->"+shemp);
			model.addAttribute("shemp", shemp);
			model.addAttribute("salDate", salDate);
			return "mh/adminSalGiveD";
		}
		
		@PostMapping("/updateSal")
	    @ResponseBody
	    public ResponseEntity<Map<String, Integer>> updateSal(
	        @RequestParam("empno") int empno,
	        @RequestParam("salBase") int salBase,
	        @RequestParam("salFood") int salFood,
	        @RequestParam("salBonus") int salBonus,
	        @RequestParam("salNight") int salNight,
	        @RequestParam("account") String account) {
		    try {
		        // 필요한 필드 값들을 업데이트하는 메서드를 호출
		        int updateResult = ss.updateSal(empno, salBase, salFood, salBonus, salNight, account);

		        // 응답 데이터를 Map으로 생성
		        Map<String, Integer> response = new HashMap<>();
		        response.put("updatedRows", updateResult); // 업데이트된 행의 개수 반환
		        System.out.println(response);

		        // 성공 응답
		        return ResponseEntity.ok(response);
		    } catch (Exception e) {
		        // 예외가 발생하면 500 응답을 보냅니다.
		        return ResponseEntity.status(500).body(null);
		    }
		}

		@GetMapping(value = "/adminSalList")
		public String sal_list (){
			System.out.println("mh admin_sal_list play~");
			return "mh/adminSalList";
		}

	
}
