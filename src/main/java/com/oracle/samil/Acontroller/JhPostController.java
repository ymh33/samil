package com.oracle.samil.Acontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/jh")
public class JhPostController {
		
	@GetMapping(value = "/post_notice")
	public String post_notice (){
		System.out.println("jh post_notice play~");
		return "jh/post_notice";
	}
	
	@GetMapping(value = "/post_free")
	public String post_free (){
		System.out.println("jh post_free play~");
		return "jh/post_free";
	}
	
	@GetMapping(value = "/post_faq")
	public String post_faq (){
		System.out.println("jh post_faq play~");
		return "jh/post_faq";
	}
}
