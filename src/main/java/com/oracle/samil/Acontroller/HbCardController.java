package com.oracle.samil.Acontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/hb")
public class HbCardController {
		
		@GetMapping(value = "/cost_card")
		public String cost_card (){
			System.out.println("hb card play~");
			return "hb/cost_card";
		}
		
		@GetMapping(value = "/admin_cost_card")
		public String admin_cost_card (){
			System.out.println("hb admin_cost_card play~");
			return "hb/admin_cost_card";
		}
		
}
