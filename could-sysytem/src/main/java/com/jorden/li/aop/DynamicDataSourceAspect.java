package com.jorden.li.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jorden.li.core.DynamicDataSource;
import com.jorden.li.enums.DynDataSourceEnum;


/**
 * 
 * @ClassName: DynamicDataSourceAspect
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: jorden.li
 * @date: 2018年4月2日 下午1:21:36
 * 
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. Success is never
 *             final. Failure is never fatal. Courage is what counts. -Sir
 *             Winston Churchill
 */
@Order(-1) // 在 @Transactional 执行
@Aspect
@Component
public class DynamicDataSourceAspect {
	
	public Logger logger=LoggerFactory.getLogger(DynamicDataSourceAspect.class);

	@Before(value = "execution(* com.jorden.li.service..*.*(..))")
	public void changeDataSource(JoinPoint point) throws Throwable {

		/* 获取当前的方法 */
		Class currentClass = point.getTarget().getClass();
		logger.info("访问当前的类:  " + currentClass.getName());
		//slaveDataSource masterDataSource
		//定义的接口方法  
        Method abstractMethod = ((MethodSignature) point.getSignature()).getMethod();  
        String currentMethodName=abstractMethod.getName().toUpperCase();
        if(currentMethodName.contains(DynDataSourceEnum.SELECT.toString())||currentMethodName.contains(DynDataSourceEnum.FIND.toString())){
        	logger.info("切换数据源，现在是读请求");
        	DynamicDataSource.setDataSource("master");
        	
        }else{
        	logger.info("切换数据源，现在是写请求");
        	DynamicDataSource.setDataSource("slave");
        }
	}

	@Pointcut("execution(* com.jorden.li.service..*.*(..))")
	public void pointCut() {
	}

	@After("pointCut()")
	public void after(JoinPoint point) {
		logger.info("after");
//		 DynamicDataSource.clearDataSource();
	}

}
