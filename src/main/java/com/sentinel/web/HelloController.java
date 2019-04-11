package com.sentinel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sentinel.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/foo")
	public String foo() throws Exception {
		helloService.test();
		return helloService.hello(System.currentTimeMillis());
	}

}
