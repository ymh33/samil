package com.oracle.samil.Acontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.Amodel.Sal;
import com.oracle.samil.MhService.Paging;
import com.oracle.samil.MhService.SalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/mh")
public class MhSalController {
	private final SalService ss;
		
		@GetMapping(value = "/sal_join")
		public String sal_join (){
			System.out.println("mh sal_join play~");
			return "mh/sal_join";
		}
		
		@GetMapping(value = "/admin_sal_set")
		public String empList (Emp emp, Model model){
			int totalSal =  ss.totalSal();
			String currentPage = "1";
			
			Paging page = new Paging(totalSal, emp.getCurrentPage());
			emp.setStart(page.getStart());
			emp.setEnd(page.getEnd());


			System.out.println("Sal->" + totalSal);
			List<Emp> listEmp = ss.totalEmp(emp);
			model.addAttribute("totalSal", totalSal);
			model.addAttribute("listEmp", listEmp);
			model.addAttribute("page", page);
			
			System.out.println("listEmp->" + listEmp);
			
			return "mh/admin_sal_set";
			
			
			
		}


		
		@GetMapping(value = "/admin_sal_give")
		public String sal_give (){
			System.out.println("mh admin_sal_give play~");
			return "mh/admin_sal_give";
		}
		
		@GetMapping(value = "/admin_sal_list")
		public String sal_list (){
			System.out.println("mh admin_sal_list play~");
			return "mh/admin_sal_list";
		}

	
}
