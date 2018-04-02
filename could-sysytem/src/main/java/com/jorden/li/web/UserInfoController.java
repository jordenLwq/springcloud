/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.jorden.li.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.jorden.li.auth.annotation.Authoriation;
import com.jorden.li.model.UserInfo;
import com.jorden.li.service.impl.UserInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * **************************************************************** Java Lib For Android, Powered By jorden.li Copyright
 * (c) 2001-2014 Digital Telemedia Co.,Ltd https://jordenlwq.github.io/ Package: com.jorden.li.web Filename:
 * UserInfoController.java Description: TODO(用一句话描述该文件做什么) Copyright: Copyright (c) 2001-2014 Company: Digital Telemedia
 * Co.,Ltd
 * 
 * @author: jorden.li
 * @version: 1.0.0 Create at: 2017年12月29日 下午1:05:31 Revision: 2017年12月29日 下午1:05:31 - first revision
 */
@RestController
@RequestMapping("/users")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    

    @RequestMapping(value = "/add")
    public void add(UserInfo country) {
    	userInfoService.save(country);
    }
    /**
     * 
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param id
     * @return
     */
    @RequestMapping(value = "/view/{id}")
    public ResponseEntity<UserInfo> view(@PathVariable Integer id) {
        UserInfo userInfo = userInfoService.getById(id);
        return ResponseEntity.ok(userInfo);
    }

    /**
     * 
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param id
     * @return
     */
    @PostMapping(value = "/delete/{id}")
    public void delete(Integer id) {
        userInfoService.deleteById(id);
    }

  

    @RequestMapping(value="/list/{page}/{size}",method=RequestMethod.GET)
//    @HystrixCommand
    @Authoriation
    public ResponseEntity<List> list(HttpServletRequest request,@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
    	System.out.println("authorization: "+request.getHeader("authorization"));
        PageHelper.startPage(page, size);
        List<UserInfo> list = userInfoService.findAll();
        return ResponseEntity.ok(list);
    }
}
