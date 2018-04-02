package com.jorden.li.auth.intercept;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jorden.li.auth.annotation.Authoriation;
import com.jorden.li.commons.bean.JWTInfo;
import com.jorden.li.core.ProjectConstant;
import com.jorden.li.service.TokenService;
import com.jorden.li.utils.HttpRequestDeviceUtils;
import com.xiaoleilu.hutool.json.JSONObject;
import com.xiaoleilu.hutool.json.JSONUtil;
import com.xiaoleilu.hutool.util.ObjectUtil;
import com.xiaoleilu.hutool.util.StrUtil;

@Component
public class AuthoriationIntercept implements HandlerInterceptor {
	
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
	
	@Autowired
	TokenService  tokenService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		boolean falg = false;

		/**
		 * 用户交互的token
		 */
		String interfaceAuthoriation = request.getHeader(ProjectConstant.AUTHORIZATION);
		if (StrUtil.isNotBlank(interfaceAuthoriation)) {
			/**
			 * 应当采用redis 缓存技术 实现用户访问接口授权
			 */
			
			HandlerMethod hm=(HandlerMethod) handler;
			System.out.println("redisTemplate:"+redisTemplate);
			
			falg = true;

		} else {
			// 这句话的意思，是让浏览器用utf8来解析返回的数据
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			
				String str = "<!DOCTYPE html><html><head>" + "<meta charset=\"utf-8\">"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
						+ " <title>系统微服务</title>" +

						" <link href=\"https://a1.muscache.com/airbnb/static/packages/common_o2.1-f8a73ee0d4378e3442aa7772f248998e.css\" media=\"all\" rel=\"stylesheet\" type=\"text/css\">"
						+

						"<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"https://a1.muscache.com/airbnb/static/logotype_favicon_pretzel-114df7f43fae7dd6dbc4ab074d934da5.ico\"></head>"
						+

						"<body>" + "  <header class=\"page-container page-container-responsive space-top-4\">"
						+ "   <a href=\"/\" class=\"icon icon-airbnb link-icon h2\">"
						+ "    <span class=\"screen-reader-only\">" + "      Airbnb" + "    </span>" + "  </a>"
						+ " </header>" +

						" <div class=\"page-container page-container-responsive\">"
						+ "  <div class=\"row space-top-8 space-8 row-table\">" + "      <div class=\"col-5 col-middle\">"
						+ "       <h1 class=\"text-jumbo text-ginormous\">Oops!</h1>"
						+ "       <h2>接口未授权</h2>"
						+ "       <h6>Error code: 503</h6>" + "        <ul class=\"list-unstyled\">"
						+ "         <li>Here are some helpful links instead:</li>"
						+ "         <li><a href=\"/\">Home</a></li>" + "         <li><a href=\"/search\">Search</a></li>"
						+ "         <li><a href=\"/help\">Help</a></li>"
						+ "         <li><a href=\"/help/getting-started/how-to-travel\">Traveling on Airbnb</a></li>"
						+ "         <li><a href=\"/info/why_host\">Hosting on Airbnb</a></li>"
						+ "        <li><a href=\"/trust\">Trust &amp; Safety</a></li>"
						+ "         <li><a href=\"/sitemaps\">Sitemap</a></li>" + "       </ul>" + "      </div>"
						+ "      <div class=\"col-5 col-middle text-center\">"
						+ "        <img src=\"https://a0.muscache.com/airbnb/static/error_pages/404-Airbnb_final-d652ff855b1335dd3eedc3baa8dc8b69.gif\" width=\"313\" height=\"428\" alt=\"Girl has dropped her ice cream.\">"
						+ "      </div>" + "     </div>" + "   </div>" + "  </div>" + "</body>" + "</html>";
				OutputStream ps = response.getOutputStream();
				  response.setHeader("Content-type", "text/html;charset=UTF-8");  
				  //这句话的意思，使得放入流的数据是utf8格式
				  ps.write(str.getBytes("UTF-8")); ps.close();
			
			falg = false;
		}

		return falg;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
