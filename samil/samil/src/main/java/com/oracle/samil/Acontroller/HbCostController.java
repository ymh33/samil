package com.oracle.samil.Acontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.samil.Amodel.Cost;
import com.oracle.samil.Amodel.CostCode;
import com.oracle.samil.HbService.CostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value="/hb")
public class HbCostController {
		
		
		private final CostService hbCostService;
		
		@GetMapping(value = "/costCost")
		public String cost_cost(Model model, Cost cost) {
			System.out.println("costCost start...");
		    List<Cost> costList = hbCostService.getCostList(cost);
		    model.addAttribute("costList", costList);
		    
		    // 기타 데이터 추가
		    Map<Integer, String> costMap = new HashMap<>();
		    costMap.put(100, "대기");
		    costMap.put(110, "승인");
		    costMap.put(120, "거부");
		    model.addAttribute("costMap", costMap);
		    
		    return "/hb/costCost";
		}
	
		@RequestMapping(value = "costPlus")
		public String cost_plus(Model model) {
			System.out.println("HbcostController submitCost start.. ");
			List<CostCode> costCode = hbCostService.getCodeList();
			model.addAttribute("costCode",costCode);
			
			System.out.println("HbCostController SubmitCost start.. ");
			
			// 신청 후 목록으로 리다이렉트
			return "hb/costPlus"; // 신청 완료 후 목록 페이지로 리다이렉트
		}
		
		
		@RequestMapping(value ="submitCost", method = RequestMethod.POST)
		public String cost_submit(Model model, Cost cost){
			System.out.println("HBcontroller submitCost start ... ");
			cost = hbCostService.addNewCost(cost);
			model.addAttribute("cost" , cost);
			return "redirect:/hb/costCost";
		}
		
		@GetMapping(value = "/costSearch")
		public String cost_search(Model model, @RequestParam("keyword") String keyword, @RequestParam("search") String search) {
			System.out.println("Hbcontroller cost_search Start...");
			Cost cost = new Cost();
		    cost.setSearch(search); // 검색 항목 설정
		    cost.setKeyword(keyword); // 검색어 설정
			List<Cost> searchCost = hbCostService.searchCost(cost);
			model.addAttribute("costList",searchCost);
			return "hb/costCost";
		}
				
		
		// 아래로는 어드민 페이지에서 구현할 것들
		
		@RequestMapping(value = "adminCostCost")
		public String admin_cost_cost (Model model, CostCode costCode){
			List<CostCode> adminCodeList = hbCostService.getCodeList();
			model.addAttribute("adminCodeList", adminCodeList);
			System.out.println("HbCostController Admin_cost_cost....");
			return "hb/adminCostCost";
		}
		
		@GetMapping(value ="adminCostCheck")
		public String admin_cost_check(Model model, Cost cost) {
			System.out.println("HBCostController  admin_cost_check start ... ");
			List<Cost> adminCostList = hbCostService.getAdminCost(cost);
			model.addAttribute("adminCostList",adminCostList);
			System.out.println("HbCostController admin_cost_check adminCostList size = >" + adminCostList.size());
			
			Map<Integer, String> adminCostMap = new HashMap<>();
			adminCostMap.put(100, "대기");
			adminCostMap.put(110, "대기");			
			model.addAttribute("costMap", adminCostMap);

			return "hb/adminCostCheck";
		}
		
		@GetMapping(value = "adminCostDetail")
		public String admin_cost_detail(Model model, Cost cost) {
			System.out.println("HBCostController admin_cost_detail start ... ");
			Cost costDetail = hbCostService.detailCost(cost.getCostTitle());
			
			 Map<Integer, String> costMap = new HashMap<>();
			 costMap.put(100, "대기");
		     costMap.put(110, "승인");
		     costMap.put(120, "거부");
		     model.addAttribute("costDetail", costDetail);
		     model.addAttribute("statusList",costMap.entrySet());
			 System.out.println("costDetail  ==> " + costDetail);
			 return "hb/adminCostDetail";
		}
		
		
		@GetMapping(value = "/adminCostPlus")
		public String admin_cost_plus(Model model) {
		    model.addAttribute("costCode", new CostCode()); // 빈 CostCode 객체를 추가
		    return "hb/adminCostPlus";
		}
		
		@PostMapping(value = "/adminCostPlusEnd")
		public String admin_cost_plus_end(Model model,  CostCode costCode) {
			System.out.println("HbCostController costCodePlus start.. ");
			 hbCostService.costCodePlus(costCode);
			return "redirect:/hb/adminCostCost";
		}

		@RequestMapping(value = "adminCostDelete")
		public String admin_cost_delete(@RequestParam("code") int costNum) {
			int costDel =  hbCostService.costCodeDel(costNum);
			System.out.println("HbCostController costDel start.. ");
			return "redirect:/hb/adminCostCost";
		}
		
		@GetMapping(value = "adminStatusSelect")
		   public String updateStatus(String costTitle, int newStatus, Model model) {
		  System.out.println("상태 변경 요청: costTitle = " + costTitle + ", newStatus = " + newStatus);

	    // 상태 변경 로직
	    try {
	        hbCostService.updateCostStatus(costTitle, newStatus); // 서비스 메소드 호출
	        model.addAttribute("message", "상태가 성공적으로 변경되었습니다.");
	    } catch (Exception e) {
	        model.addAttribute("message", "상태 변경 중 오류가 발생했습니다: " + e.getMessage());
	    }

	    // 상세 페이지로 다시 리디렉션
	    return "redirect:/adminCostDetail?costTitle=" + costTitle;
	}
		
}

		
