package com.sentinel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 
 * Exception工具类<br>
 * 版权：Copyright (c) 2016-2019<br>
 * 作者：孙常军<br>
 * 版本：1.0<br>
 * 创建日期：2019年4月12日<br>
 */
public class ExceptionUtil {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionUtil.class);

	public static void handleException(BlockException ex) {
		logger.info("Oops: {}", ex.getClass().getCanonicalName());
	}

}
