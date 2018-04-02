package com.jorden.li.limit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * ****************************************************************
 *
 *    Copyright (c) 2001-2017 Digital Telemedia Co.,Ltd
 *    http://jordenlwq.github.io/
 *    Package:     com.jorden.li.limit
 *    Filename:    ReuestLimit.java
 *    Description: TODO(用一句话描述该文件做什么)
 *    Copyright:   Copyright (c) 2001-2014
 *    Company:     Digital Telemedia Co.,Ltd
 *    @author:     jorden.li
 *    @version:    1.0.0
 *    Create at:   2017年12月27日 上午9:55:44
 *    Revision:d
 *    2017年12月27日 上午9:55:44
 *     - first revision
 ****************************************************************
 */
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
@Documented  
@Order(Ordered.LOWEST_PRECEDENCE) 
public @interface RequestLimit {
	
	/**
	 *  允许访问的次数，默认值3 
	 */
	int count() default 3;
  
	  /** 
     * 
     * 时间段，单位为毫秒，默认值10
     */  
    long time() default 10;  
}
