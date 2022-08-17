package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/home")
	public String home(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String cname=req.getParameter("cname");
		System.out.println("this is home name" +cname);
		session.getAttribute("cname");
		return "index.html";
		
	}
}
