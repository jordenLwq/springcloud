/*package com.jorden.li.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jorden.li.commons.bean.IJWTInfo;
import com.jorden.li.feign.config.FeignClientConfig;
import com.jorden.li.service.hystrix.fallback.FallBackUserServive;
*//**
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
 *//*
@FeignClient(value="COULD-AUTH",configuration=FeignClientConfig.class)
public interface UserServise {
    *//**
     * 用户列表
     * @param page 页码
     * @param size 页码大小
     * @return ResponseEntity 返回对象
     *//*
	@RequestMapping(value="/users/list/{page}/{size}",method=RequestMethod.GET)
     ResponseEntity<List> list(HttpServletRequest request, @PathVariable("page") Integer page, @PathVariable("size") Integer size);
	
	
	

}
*/