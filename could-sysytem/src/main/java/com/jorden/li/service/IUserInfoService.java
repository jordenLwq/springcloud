package com.jorden.li.service;

import java.util.List;

import com.jorden.li.model.UserInfo;

public interface IUserInfoService {
	
	public List<UserInfo> getAll(UserInfo UserInfo) ;
	
	 public UserInfo getById(Integer id);
	 
	 public List<UserInfo> findAll();
	 
	 public void deleteById(Integer id);
	 

	    public void save(UserInfo country) ;

}
