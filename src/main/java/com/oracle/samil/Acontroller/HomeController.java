package com.oracle.samil.Acontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	  
		@GetMapping(value = "/")
	    public String user_home() {
	        return "1.main/user_main";
	    }
		
		@GetMapping(value = "/user_main")
	    public String user_home1() {
	        return "1.main/user_main";
	    }
		
		@GetMapping(value = "/admin_main")
	    public String admin_home() {
	        return "1.main/admin_main";
	    }

}
