package com.oracle.samil.Acontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/hb")
public class HbCostController {
	
		@GetMapping(value = "/cost_cost")
		public String cost_cost (){
			System.out.println("hb cost_cost play~");
			return "hb/cost_cost";
		}
		
		@GetMapping(value = "admin_cost_cost")
		public String admin_cost_cost (){
			System.out.println("hb admin_cost_cost play~");
			return "hb/admin_cost_cost";
		}
		
		
}
