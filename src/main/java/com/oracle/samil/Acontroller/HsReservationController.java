package com.oracle.samil.Acontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/hs")
public class HsReservationController {
		
	@GetMapping(value = "/cal_reservation")
	public String cal_reservation (){
		System.out.println("hb cal_reservation play~");
		return "hs/cal_reservation";
	}
	
	@GetMapping(value = "/admin_cal_reservation")
	public String admin_cal_reservation (){
		System.out.println("hb admin_cal_reservation play~");
		return "hs/admin_cal_reservation";
	}
}
