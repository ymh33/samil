package com.oracle.samil.Acontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tr/")
public class TrMailController {
		
	@GetMapping(value = "/mail")
	public String mail (){
		System.out.println("tr mail play~");
		return "tr/mail";
	}
	
	@GetMapping(value = "/admin_mail")
	public String admin_mail (){
		System.out.println("tr admin_mail play~");
		return "tr/admin_mail";
	}
}
