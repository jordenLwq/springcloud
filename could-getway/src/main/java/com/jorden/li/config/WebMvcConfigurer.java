package com.jorden.li.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jorden.li.getway.component.filter.CorsFilter;


/**
 * Spring MVC 配置
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
	
	@Bean
	  public FilterRegistrationBean someFilterRegistration()
	  {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(AuthFilter());
	    registration.addUrlPatterns(new String[] { "/*" });
	    registration.setOrder(1);
	    return registration;
	  }

	  @Bean
	  public CorsFilter AuthFilter() {
	    return new CorsFilter();
	  }
	  
	  
}

