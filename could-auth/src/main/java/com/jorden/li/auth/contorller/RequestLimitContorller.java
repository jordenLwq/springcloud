package com.jorden.li.auth.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorden.li.auth.service.RequestLimitService;
/**
 * 
 * @ClassName:  RequestLimitContorller   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jorden.li
 * @date:   2018年3月23日 下午2:07:05   
 *     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 * Success is never final. Failure is never fatal. Courage is what counts. -Sir Winston Churchill
 */
@RestController
@RequestMapping("/limit/")
public class RequestLimitContorller {
	
	@Autowired
	RequestLimitService requestLimitService;
	
	@RequestMapping("/token")
	public boolean RequeatLimit(@PathVariable ("token") String token){
		return requestLimitService.isAccess(token);
		
	}

}
