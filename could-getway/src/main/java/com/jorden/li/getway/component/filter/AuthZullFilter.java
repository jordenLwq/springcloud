package com.jorden.li.getway.component.filter;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.core.Ordered;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.google.common.util.concurrent.RateLimiter;
import com.jorden.li.commons.bean.JWTInfo;
import com.jorden.li.service.TokenService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 所有微服务认证中心
 * 
 * @ClassName: AuthZullFilter
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: jorden.li
 * @date: 2018年3月2日 下午3:53:42
 * 
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. Success is never
 *             final. Failure is never fatal. Courage is what counts. -Sir
 *             Winston Churchill
 */
@Component
public class AuthZullFilter extends ZuulFilter {

	 RateLimiter rateLimiter = RateLimiter.create(2);  
	@Autowired
	TokenService tokenService;

	@Override
	public Object run() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String accessKey = request.getHeader("accessKey");
		String secretKey = request.getHeader("secretKey");
		ResponseEntity<JWTInfo>  res= 	tokenService.getTokenInfo(accessKey);
		 
		boolean falg=  rateLimiter.tryAcquire(1000,TimeUnit.MILLISECONDS);
		System.out.println(falg);
		  
		  if(falg){
			  
			  currentContext.setSendZuulResponse(true);  
				currentContext.getResponse().setCharacterEncoding("UTF-8");
				currentContext.setResponseStatusCode(200);  
				String str = "<!DOCTYPE html><html><head>" + "<meta charset=\"utf-8\">"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
						+ " <title>Getway系统提示</title>" +

						" <link href=\"https://a1.muscache.com/airbnb/static/packages/common_o2.1-f8a73ee0d4378e3442aa7772f248998e.css\" media=\"all\" rel=\"stylesheet\" type=\"text/css\">"
						+

						"<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"https://a1.muscache.com/airbnb/static/logotype_favicon_pretzel-114df7f43fae7dd6dbc4ab074d934da5.ico\"></head>"
						+

						"<body>" + "  <header class=\"page-container page-container-responsive space-top-4\">"
						+ "   <a href=\"/\" class=\"icon icon-airbnb link-icon h2\">"
						+ "    <span class=\"screen-reader-only\">" + "      Airbnb" + "    </span>" + "  </a>"
						+ " </header>" +

						" <div class=\"page-container page-container-responsive\">"
						+ "  <div class=\"row space-top-8 space-8 row-table\">"
						+ "      <div class=\"col-5 col-middle\">"
						+ "       <h1 class=\"text-jumbo text-ginormous\">Oops!</h1>" + "       <h2>请求次数过多，请稍后重试</h2>"
						+ "       <h6>Error code: 403</h6>" + "        <ul class=\"list-unstyled\">"
						+ "         <li>Here are some helpful links instead:</li>"
						+ "         <li><a href=\"/\">Home</a></li>"
						+ "         <li><a href=\"/search\">Search</a></li>"
						+ "         <li><a href=\"/help\">Help</a></li>"
						+ "         <li><a href=\"/help/getting-started/how-to-travel\">Traveling on Airbnb</a></li>"
						+ "         <li><a href=\"/info/why_host\">Hosting on Airbnb</a></li>"
						+ "        <li><a href=\"/trust\">Trust &amp; Safety</a></li>"
						+ "         <li><a href=\"/sitemaps\">Sitemap</a></li>" + "       </ul>" + "      </div>"
						+ "      <div class=\"col-5 col-middle text-center\">"
						+ "        <img src=\"https://a0.muscache.com/airbnb/static/error_pages/404-Airbnb_final-d652ff855b1335dd3eedc3baa8dc8b69.gif\" width=\"313\" height=\"428\" alt=\"Girl has dropped her ice cream.\">"
						+ "      </div>" + "     </div>" + "   </div>" + "  </div>" + "</body>" + "</html>";
				currentContext.setResponseBody(str);// 输出最终结果  
		  }
		JWTInfo jwt=res.getBody();
		if("NODATAS".equals(jwt.getName())){
			currentContext.setSendZuulResponse(true);  
			currentContext.getResponse().setCharacterEncoding("UTF-8");
			currentContext.setResponseStatusCode(200);  
			String str = "<!DOCTYPE html><html><head>" + "<meta charset=\"utf-8\">"
					+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
					+ " <title>Getway系统提示</title>" +

					" <link href=\"https://a1.muscache.com/airbnb/static/packages/common_o2.1-f8a73ee0d4378e3442aa7772f248998e.css\" media=\"all\" rel=\"stylesheet\" type=\"text/css\">"
					+

					"<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"https://a1.muscache.com/airbnb/static/logotype_favicon_pretzel-114df7f43fae7dd6dbc4ab074d934da5.ico\"></head>"
					+

					"<body>" + "  <header class=\"page-container page-container-responsive space-top-4\">"
					+ "   <a href=\"/\" class=\"icon icon-airbnb link-icon h2\">"
					+ "    <span class=\"screen-reader-only\">" + "      Airbnb" + "    </span>" + "  </a>"
					+ " </header>" +

					" <div class=\"page-container page-container-responsive\">"
					+ "  <div class=\"row space-top-8 space-8 row-table\">"
					+ "      <div class=\"col-5 col-middle\">"
					+ "       <h1 class=\"text-jumbo text-ginormous\">Oops!</h1>" + "       <h2>非法请求</h2>"
					+ "       <h6>Error code: 503</h6>" + "        <ul class=\"list-unstyled\">"
					+ "         <li>Here are some helpful links instead:</li>"
					+ "         <li><a href=\"/\">Home</a></li>"
					+ "         <li><a href=\"/search\">Search</a></li>"
					+ "         <li><a href=\"/help\">Help</a></li>"
					+ "         <li><a href=\"/help/getting-started/how-to-travel\">Traveling on Airbnb</a></li>"
					+ "         <li><a href=\"/info/why_host\">Hosting on Airbnb</a></li>"
					+ "        <li><a href=\"/trust\">Trust &amp; Safety</a></li>"
					+ "         <li><a href=\"/sitemaps\">Sitemap</a></li>" + "       </ul>" + "      </div>"
					+ "      <div class=\"col-5 col-middle text-center\">"
					+ "        <img src=\"https://a0.muscache.com/airbnb/static/error_pages/404-Airbnb_final-d652ff855b1335dd3eedc3baa8dc8b69.gif\" width=\"313\" height=\"428\" alt=\"Girl has dropped her ice cream.\">"
					+ "      </div>" + "     </div>" + "   </div>" + "  </div>" + "</body>" + "</html>";
			currentContext.setResponseBody(str);// 输出最终结果  
		}
      currentContext.addZuulRequestHeader("authorization", accessKey);
      currentContext.addZuulRequestHeader("accessKey", accessKey);
		
		System.err.println(res.getBody());
		return currentContext;

	}

	@Override
	public boolean shouldFilter() {
		// 这里可以考虑弄个限流开启的开关，开启限流返回true，关闭限流返回false， @value
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return Ordered.HIGHEST_PRECEDENCE;
	}

	@Override
	public String filterType() {

		return FilterConstants.PRE_TYPE;
	}

}
