package com.oracle.samil.Acontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/hb")
public class HbUtilityController {
	
	@GetMapping(value = "/cost_utility")
	public String cost_utility (){
		System.out.println("hb cost_utility play~");
		return "hb/cost_utility";
	}
	
	@GetMapping(value = "/admin_cost_utility")
	public String admin_cost_utility (){
		System.out.println("hb admin_cost_utility play~");
		return "hb/admin_cost_utility";
	}
}
