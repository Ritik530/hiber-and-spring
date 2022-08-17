package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NyController {
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("this is home name ");
		
		return "index.html";
		
	}

}
