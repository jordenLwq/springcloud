/*package com.jorden.li.consume.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorden.li.service.UserServise;

@RestController
public class UserConsume {

	
	@Resource
	UserServise userServise;
	@RequestMapping(value="/users/list/{page}/{size}",method=RequestMethod.GET)
    public ResponseEntity<List> list(HttpServletRequest request, @PathVariable("page") Integer page, @PathVariable("size") Integer size){
		return userServise.list( request, page, size);
		
	}
	
}
*/