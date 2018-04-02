package com.jorden.li.eureka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * 
 * @author jorden.li
 * @desc eurka服务注册中心
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicationStart {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplicationStart.class, args);
	}

}
