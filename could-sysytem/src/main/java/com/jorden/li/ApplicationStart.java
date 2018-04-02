package com.jorden.li;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * **************************************************************** Copyright (c) 2001-2017 Digital Telemedia Co.,Ltd
 * http://jordenlwq.github.io/ Package: com.jorden.li Filename: ApplicationStart.java Description: TODO(用一句话描述该文件做什么)
 * Copyright: Copyright (c) 2001-2014 Company: Digital Telemedia Co.,Ltd
 * 
 * @author: jorden.li
 * @version: 1.0.0 Create at: 2017年12月27日 上午9:55:07 Revision: 2017年12月27日 上午9:55:07 - first revision
 */
@MapperScan(basePackages = "com.jorden.li.dao")
@SpringBootApplication(exclude={RabbitAutoConfiguration.class,MybatisAutoConfiguration.class})
@EnableEurekaClient
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages="com.jorden.li.service")
public class ApplicationStart {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationStart.class, args);
	}
}
