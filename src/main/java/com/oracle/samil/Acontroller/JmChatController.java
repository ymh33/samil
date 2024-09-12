package com.oracle.samil.Acontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/jm")
public class JmChatController {
		
	@GetMapping(value = "/chat")
	public String chat (){
		System.out.println("jm chat play~");
		return "jm/chat";
	}
}
