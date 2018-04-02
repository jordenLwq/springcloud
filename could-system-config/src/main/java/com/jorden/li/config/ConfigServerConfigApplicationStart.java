package com.jorden.li.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerConfigApplicationStart {

	
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerConfigApplicationStart.class, args);
	}
}
