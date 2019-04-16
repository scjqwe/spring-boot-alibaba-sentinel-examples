package com.sentinel.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/busy")
	public String busy(){
		return "busy";
	}
	
}
