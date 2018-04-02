package com.jorden.li.commons.bean;

/**
 * API认证参数类
 * 
 * @ClassName: AuthQuery
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: jorden.li
 * @date: 2018年3月6日 下午4:05:25
 * 
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. Success is never
 *             final. Failure is never fatal. Courage is what counts. -Sir
 *             Winston Churchill
 */
public class AuthQuery {
	private String accessKey;

	private String secretKey;

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

}
