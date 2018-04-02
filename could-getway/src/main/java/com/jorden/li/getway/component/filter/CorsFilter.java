package com.jorden.li.getway.component.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName="CorsFilter", urlPatterns={"/*"})
public class CorsFilter
  implements Filter
{
  public void init(FilterConfig filterConfig)
    throws ServletException
  {
    System.out.println("*********************************过滤器初始化**************************");
  }

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse)res;
    response.addHeader("Access-Control-Allow-Origin", "*");
    response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
    response.addHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type,Authorization,Accept, Origin, XRequestedWith, LastModified, token,X-Prototype-Version");
    response.addHeader("Access-Control-Max-Age", "3600");
    response.addHeader("access-control-expose-headers", "x-json");
    System.out.println("*********************************过滤器被使用**************************");
    chain.doFilter(req, res);
  }

  public void destroy() {
    System.out.println("*********************************过滤器被销毁**************************");
  }
}