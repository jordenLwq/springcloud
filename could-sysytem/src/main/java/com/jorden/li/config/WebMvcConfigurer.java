package com.jorden.li.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring MVC 配置
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
	
	/*@Bean
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
	  */
	   @Override
		public void addInterceptors(InterceptorRegistry registry) {
		 /* registry.addInterceptor(new AuthoriationIntercept())  
          .addPathPatterns("/**");   */   
		}
}
