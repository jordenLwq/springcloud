package com.jorden.li.auth.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorden.li.auth.service.AuthService;
import com.jorden.li.commons.bean.IJWTInfo;

@RestController
@RequestMapping("/auth")
public class AuthContorller {

   @Autowired
   AuthService authService;
   
   /**
    * 获取token
    * @Title: getToken   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param: @param accessKey
    * @param: @return      
    * @return: ResponseEntity<String>      
    * @throws
    */
   @RequestMapping(value = "/token", method = RequestMethod.POST)	
	public ResponseEntity<String> getToken(String accessKey){
		 String res=authService.auth(accessKey);
		return  ResponseEntity.ok(res);
		
	}
	
	/**
	 * 刷新token
	 * @Title: refresh   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param token
	 * @param: @return      
	 * @return: ResponseEntity<String>      
	 * @throws
	 */
	public ResponseEntity<String> refresh(String token){
		 String res=authService.refresh(token);
			return  ResponseEntity.ok(res);
	};
	
	/**
	 * 获取token信息
	 * @Title: getTokenInfo   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param token
	 * @param: @return      
	 * @return: ResponseEntity<IJWTInfo>      
	 * @throws
	 */
	@RequestMapping(value = "/getInfo", method = RequestMethod.POST)
	public ResponseEntity<IJWTInfo> getTokenInfo(String token){
		return ResponseEntity.ok( authService.getTokenInfo(token));
	}
}
