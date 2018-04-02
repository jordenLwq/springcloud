package com.jorden.li.auth.service;

public interface RequestLimitService {
	
	  /**
	   * 是否可以访问
	   * @Title: isAccess   
	   * @Description: TODO(这里用一句话描述这个方法的作用)   
	   * @param: @param key
	   * @param: @return      
	   * @return: boolean      
	   * @throws
	   */
	 boolean isAccess(String key);

}
