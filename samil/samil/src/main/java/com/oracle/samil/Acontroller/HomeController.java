package com.oracle.samil.Acontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.TrService.EmpService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	@Autowired
	private EmpService es;

	@GetMapping(value = "/")
	public String user_home() {
		return "tr/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("empno") String empno, @RequestParam("password") String password, Model model,
			HttpSession session) {
		boolean isValidUser = es.validateUser(empno, password);

		Emp emp = es.findEmpbyEmpno(empno);
		if (isValidUser) {
			session.setAttribute("emp", emp);
			return "1.main/user_main"; // 로그인 성공 시 이동할 페이지
		} else {
			model.addAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return "login"; // 로그인 실패 시 다시 로그인 페이지로 이동
		}
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("emp");

		return "redirect:/"; // 세션이 없으면 로그인 페이지로 리다이렉트
	}

	@GetMapping(value = "/user_main")
	public String user_home1(HttpSession session, Model model) {
		Emp emp = (Emp) session.getAttribute("emp"); // 세션에서 emp 객체 가져오기

		if (emp != null) {
			model.addAttribute("emp", emp); // 모델에 emp 추가
			return "1.main/user_main"; // 페이지 반환
		} else {
			return "redirect:/login"; // 세션이 없으면 로그인 페이지로 리다이렉트
		}
	}

	@GetMapping(value = "/admin_main")
	public String admin_home(HttpSession session, Model model) {
		Emp emp = (Emp) session.getAttribute("emp"); // 세션에서 emp 객체 가져오기

		if (emp != null) {
			model.addAttribute("emp", emp); // 모델에 emp 추가
			return "1.main/admin_main"; // 페이지 반환
		} else {
			return "redirect:/login"; // 세션이 없으면 로그인 페이지로 리다이렉트
		}
	}
}
