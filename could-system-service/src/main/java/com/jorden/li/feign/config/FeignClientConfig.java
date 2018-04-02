package com.jorden.li.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

/**
 * 
 * TODO(描述类的职责)
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:HP,date:2018年3月1日 上午11:09:37,content:TODO </p>
 * @author HP
 * @date 2018年3月1日 上午11:09:37
 * @since
 * @version
 *
 * 
 *
 *  http://www.ewininfo.com
 */
@Configuration
public class FeignClientConfig {
	
	@Bean
	public Logger.Level getLog(){
		return feign.Logger.Level.FULL;
	}
	
	@Bean
	public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {

		return new BasicAuthRequestInterceptor("admin", "123");
	}

}
