
package com.jorden.li.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jorden.li.dao.UserInfoMapper;
import com.jorden.li.model.UserInfo;
import com.jorden.li.service.IUserInfoService;

/**
 * **************************************************************** Java Lib For
 * Android, Powered By jorden.li Copyright (c) 2001-2014 Digital Telemedia
 * Co.,Ltd https://jordenlwq.github.io/ Package: com.jorden.li.service.impl
 * Filename: UserInfoService.java Description: TODO(用一句话描述该文件做什么) Copyright:
 * Copyright (c) 2001-2014 Company: Digital Telemedia Co.,Ltd
 * 
 * @author: jorden.li
 * @version: 1.0.0 Create at: 2018年1月2日 上午9:29:05 Revision: 2018年1月2日 上午9:29:05
 *           - first revision
 */
@Service
public class UserInfoService implements IUserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	public List<UserInfo> getAll(UserInfo UserInfo) {
		if (UserInfo.getPage() != null && UserInfo.getRows() != null) {
			PageHelper.startPage(UserInfo.getPage(), UserInfo.getRows());
		}
		return userInfoMapper.selectAll();
	}

	public UserInfo getById(Integer id) {
		return userInfoMapper.selectByPrimaryKey(id);
	}

	public List<UserInfo> findAll() {
		return userInfoMapper.selectAll();
	}

	public void deleteById(Integer id) {
		userInfoMapper.deleteByPrimaryKey(id);
	}

	public void save(UserInfo country) {
		if (country.getId() != null) {
			userInfoMapper.updateByPrimaryKey(country);
		} else {
			userInfoMapper.insert(country);
		}
	}
}
