package com.jorden.li.auth.service;

import com.jorden.li.commons.bean.IJWTInfo;

/**
 * 
 * @ClassName:  AuthService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jorden.li
 * @date:   2018年3月16日 下午1:00:35   
 *     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 * Success is never final. Failure is never fatal. Courage is what counts. -Sir Winston Churchill
 */
public interface AuthService {

	
	/**
	 * 获取token
	 * @Title: auth   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param aq
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	String auth(String accessKey);
	
	/**
	 * 注销token
	 * @Title: invalidate   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param token      
	 * @return: void      
	 * @throws
	 */
	void invalidate(String token);
	
	
	
	/**
	 * 刷新token
	 * @Title: refresh   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param token
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
    String refresh(String token);
    /**
     * 获取token信息
     * @Title: getTokenInfo   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param act
     * @param: @param token
     * @param: @return      
     * @return: IJWTInfo      
     * @throws
     */
    IJWTInfo getTokenInfo(String token);
	
	
	
	
	
	
}
