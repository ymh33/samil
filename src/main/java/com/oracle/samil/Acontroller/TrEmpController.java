package com.oracle.samil.Acontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/tr")
public class TrEmpController {
	
	@GetMapping(value = "/per_search")
	public String per_search (){
		System.out.println("tr per_search play~");
		return "tr/per_search";
	}
		
	@GetMapping(value = "/per_check")
	public String per_check (){
		System.out.println("tr per_check play~");
		return "tr/per_check";
	}
	
	@GetMapping(value = "/admin_per_inform")
	public String admin_per_inform (){
		System.out.println("tr admin_per_inform play~");
		return "tr/admin_per_inform";
	}
	
	@GetMapping(value = "/admin_per_manage")
	public String admin_per_manage (){
		System.out.println("tr admin_per_manage play~");
		return "tr/admin_per_manage";
	}
	
	@GetMapping(value = "/admin_group_check")
	public String admin_group_check (){
		System.out.println("tr admin_group_check play~");
		return "tr/admin_group_check";
	}
}
