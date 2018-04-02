/*package com.jorden.li.service.hystrix.fallback;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jorden.li.service.UserServise;

import feign.hystrix.FallbackFactory;

*//**
 *
 *//*
@Component
public class FallBackUserServive  implements FallbackFactory<UserServise>{

	@Override
	public UserServise create(Throwable arg0) {
		return new UserServise() {
			
			@SuppressWarnings("unchecked")
			@Override
			public ResponseEntity<List> list(HttpServletRequest request, Integer page, Integer size) {
				List infos =new ArrayList();
				infos.add("服务不可用");
				return ResponseEntity.ok(infos);
			}
		};
	}

	

}
*/