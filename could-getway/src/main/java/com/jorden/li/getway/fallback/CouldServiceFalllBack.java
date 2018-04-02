package com.jorden.li.getway.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 微服务失败回退
 * 
 * @ClassName: CouldSystemFaillBack
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: jorden.li
 * @date: 2018年3月5日 下午4:37:19
 * 
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. Success is never
 *             final. Failure is never fatal. Courage is what counts. -Sir
 *             Winston Churchill
 */
@Component
public class CouldServiceFalllBack implements FallbackProvider {

	@Override
	public String getRoute() {
		// * 代表所有的微服务
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		// TODO Auto-generated method stub
		return this.fallbackResponse();
	}

	@Override
	public ClientHttpResponse fallbackResponse(Throwable cause) {
		// TODO Auto-generated method stub
		return new ClientHttpResponse() {

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.TEXT_HTML);
				return headers;
			}

			@Override
			public InputStream getBody() throws IOException {
				// TODO Auto-generated method stub
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
						+ "       <h1 class=\"text-jumbo text-ginormous\">Oops!</h1>" + "       <h2>系统微服务异常</h2>"
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
				return new ByteArrayInputStream(str.toString().getBytes());
			}

			@Override
			public String getStatusText() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST.value();
			}

			@Override
			public void close() {

			}
		};
	}

}
