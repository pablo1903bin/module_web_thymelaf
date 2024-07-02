package com.appweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
  
	@GetMapping("/home")
	public String mostrarHome() {
		return "redirect:/not_found_content";
	}

}

