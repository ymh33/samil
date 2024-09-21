package com.oracle.samil.Acontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/se")
public class SeApprovalController {
	
	@GetMapping(value = "/app_all")
	public String app_all (){
		System.out.println("se app_all play~");
		return "se/app_all";
	}
	
	@GetMapping(value = "/app_finish")
	public String app_finish (){
		System.out.println("se app_finish play~");
		return "se/app_finish";
	}
	
	@GetMapping(value = "/app_stand")
	public String app_stand (){
		System.out.println("se app_stand play~");
		return "se/app_stand";
	}
	
	@GetMapping(value = "/admin_app_all")
	public String admin_app_all (){
		System.out.println("se admin_app_all play~");
		return "se/admin_app_all";
	}
}
