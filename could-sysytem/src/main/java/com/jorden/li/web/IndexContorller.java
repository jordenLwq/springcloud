package com.jorden.li.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jorden.li.limit.RequestLimit;
/**
 * ****************************************************************
 *
 *    Copyright (c) 2001-2017 Digital Telemedia Co.,Ltd
 *    http://jordenlwq.github.io/
 *    Package:     com.jorden.li.web
 *    Filename:    IndexContorller.java
 *    Description: TODO(用一句话描述该文件做什么)
 *    Copyright:   Copyright (c) 2001-2014
 *    Company:     Digital Telemedia Co.,Ltd
 *    @author:     jorden.li
 *    @version:    1.0.0
 *    Create at:   2017年12月27日 上午9:55:14
 *    Revision:
 *    2017年12月27日 上午9:55:14
 *     - first revision
 ****************************************************************
 */
@RestController
@RequestMapping("/home")
public class IndexContorller {

	//HttpServletRequest request,HttpServletResponse response
	@RequestMapping("/index")
	@RequestLimit()  
	public @ResponseBody  ResponseEntity<String> index(HttpServletRequest request,HttpServletResponse response ) {
		return ResponseEntity.ok("request success ");
 	}
	
}
