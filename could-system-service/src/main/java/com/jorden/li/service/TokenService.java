package com.jorden.li.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jorden.li.commons.bean.IJWTInfo;
import com.jorden.li.commons.bean.JWTInfo;
import com.jorden.li.feign.config.FeignClientConfig;
/**
 * 
 * TODO(User service Feign转发服务)
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:HP,date:2018年3月1日 上午11:14:13,content:TODO </p>
 * @author lwq
 * @date 2018年3月1日 上午11:14:13
 * @since 1.0.0
 * @version
 *
 *	此代码由易往通用服务平台项目开发小组开发完成, 仅限易往信息内部使用 
 *  外部使用该代码将付相应的法律责任
 *  更多信息请查询
 * 
 *
 *  http://www.ewininfo.com
 */
@FeignClient(value="COULD-AUTH",configuration=FeignClientConfig.class)
public interface TokenService {

	  /**
	    * 获取token
	    * @Title: getToken   
	    * @Description: TODO(这里用一句话描述这个方法的作用)   
	    * @param: @param accessKey
	    * @param: @return      
	    * @return: ResponseEntity<String>      
	    * @throws
	    */
		@RequestMapping(value = "/auth/token", method = RequestMethod.POST)
		public ResponseEntity<String> getToken( @RequestParam("accessKey") String accessKey);
			
		
			
		
		/**
		 * 获取token信息
		 * @Title: getTokenInfo   
		 * @Description: TODO(这里用一句话描述这个方法的作用)   
		 * @param: @param token
		 * @param: @return      
		 * @return: ResponseEntity<IJWTInfo>      
		 * @throws
		 */
		@RequestMapping(value = "/auth/getInfo", method = RequestMethod.POST)
		public ResponseEntity<JWTInfo> getTokenInfo( @RequestParam("token")   String token);
	
	

}
