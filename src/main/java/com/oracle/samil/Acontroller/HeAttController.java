package com.oracle.samil.Acontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/he")
public class HeAttController {

	@GetMapping(value = "/att")
	public String att (){
		System.out.println("he att play~");
		return "he/att";
	}
	
	@GetMapping(value = "/admin_att")
	public String admin_att (){
		System.out.println("he admin_att play~");
		return "he/admin_att";
	}
}
