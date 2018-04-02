package com.jorden.li.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jorden.li.exption.RequestLimitException;
/**
 * ****************************************************************
 *
 *    Copyright (c) 2001-2017 Digital Telemedia Co.,Ltd
 *    http://jordenlwq.github.io/
 *    Package:     com.jorden.li.config
 *    Filename:    RequestLimitHanlder.java
 *    Description: TODO(用一句话描述该文件做什么)
 *    Copyright:   Copyright (c) 2001-2014
 *    Company:     Digital Telemedia Co.,Ltd
 *    @author:     jorden.li
 *    @version:    1.0.0
 *    Create at:   2017年12月27日 上午9:56:22
 *    Revision:
 *    2017年12月27日 上午9:56:22
 *     - first revision
 ****************************************************************
 */
@ControllerAdvice
@ResponseBody
public class RequestLimitHanlder {
	  private final Logger logger = LoggerFactory.getLogger(RequestLimitHanlder.class);
	  
	 /**
	  * 
	  * @Description (请求限流异常处理)
	  * @param e RequestLimitException 
	  * @return 返回异常信息
	  */
	@ExceptionHandler(RequestLimitException.class)
    public Object handleException(RequestLimitException e) {
        return e.getMessage();
    }

	
}
