package com.sentinel.service;

import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sentinel.util.ExceptionUtil;

/**
 * 
 * HelloService<br>
 * 版权：Copyright (c) 2016-2019<br>
 * 作者：孙常军<br>
 * 版本：1.0<br>
 * 创建日期：2019年4月12日<br>
 */
@Service
public class HelloService {
	
	@SentinelResource(value = "test", blockHandler = "handleException", blockHandlerClass = { ExceptionUtil.class })
	public void test() {
		System.out.println("Test");
	}

	@SentinelResource(value = "hello", blockHandler = "exceptionHandler")
	public String hello(long s) {
		return String.format("Hello at %d", s);
	}

	public String exceptionHandler(long s, BlockException ex) {
		// Do some log here.
		ex.printStackTrace();
		return "Oops, error occurred at " + s;
	}
}
