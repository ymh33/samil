package com.oracle.samil.Acontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/hs")
public class HsCalController {
	
	@GetMapping(value = "/cal")
	public String cal (){
		System.out.println("hb cal play~");
		return "hs/cal";
	}
	
	@GetMapping(value = "/admin_cal")
	public String admin_cal (){
		System.out.println("hb admin_cal play~");
		return "hs/admin_cal";
	}
}
