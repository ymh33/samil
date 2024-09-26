package com.oracle.samil.Acontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.samil.Amodel.Utility;
import com.oracle.samil.HbService.UtilityService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value="/hb")
public class HbUtilityController {
		
		private final UtilityService hbUtilityService;
	 
	  @GetMapping(value = "/costUtility")
	    public String utilityChart(Model model, Utility utility) {
		    List<Utility> utilityList = hbUtilityService.getUtilityData();
	        model.addAttribute("utilityData", utilityList);
	        System.out.println("utilityList size : " + utilityList.size());
			Map<Integer, String> utilityMap = new HashMap<>();
			utilityMap.put(100, "수도세");
			utilityMap.put(110, "전기세");
			utilityMap.put(120, "관리비");
			model.addAttribute("utilityMap",utilityMap);
	        return "hb/costUtility"; // JSP 뷰 이름
	    }
	
	@GetMapping(value = "/adminCostUtility")
	public String admin_cost_utility (){
		System.out.println("hb adminCostUtility play~");
		return "hb/adminCostUtility";
	}
	

}
