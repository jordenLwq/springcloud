package com.jorden.li.limit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jorden.li.exption.RequestLimitException;
import com.xiaoleilu.hutool.util.ObjectUtil;

/**
 * **************************************************************** Copyright (c) 2001-2017 Digital Telemedia Co.,Ltd
 * http://jordenlwq.github.io/ Package: com.jorden.li.limit Filename: RequestLimitContract.java Description:
 * TODO(用一句话描述该文件做什么) Copyright: Copyright (c) 2001-2014 Company: Digital Telemedia Co.,Ltd
 * 
 * @author: jorden.li
 * @version: 1.0.0 Create at: 2017年12月27日 上午9:56:01 Revision: 2017年12月27日 上午9:56:01 - first revision
 */

@Aspect
@Component
public class RequestLimitContract {

    private static final Logger logger = LoggerFactory.getLogger(RequestLimitContract.class);

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    /**
     * 初始化
     */
    private static final int init = 0;

    @Before("within(@org.springframework.web.bind.annotation.RequestMapping *) && @annotation(ReuestLimit)")
    public void requestLimit(final JoinPoint joinPoint, RequestLimit ReuestLimit) throws RequestLimitException {
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = null;
        for (Object object : args) {
            if (object instanceof HttpServletRequest) {
                request = (HttpServletRequest) object;
            }
        }
        if (ObjectUtil.isNull(request)) {
            throw new RequestLimitException("This interface lacks HttpServletRequest object injection");
        }
       System.err.println("请求地址："+request.getRequestURI());
        String ip = getRealIp(request);
        String url = request.getRequestURL().toString();
        String key = "req_limit_".concat(url).concat(ip);
        // 判断是否第一次访问
        String value = redisTemplate.boundValueOps(key).get();
        if (StringUtils.isEmpty(value)) {
            redisTemplate.boundValueOps(key).set(init + "");
        } else {
            int current = Integer.parseInt(redisTemplate.boundValueOps(key).get());
            current++;
            redisTemplate.boundValueOps(key).set(current + "");
            if (current >= ReuestLimit.count()) {
                redisTemplate.boundValueOps(key).set(ReuestLimit.count() + "");
                logger.debug("ip:" + ip + "超出");
                throw new RequestLimitException(
                        "This request exceeds the access limit，please" + ReuestLimit.time() + "s" + "try again。Please contact the administrator Email:lwq.jorden@gmail.com ");
            }
        }
        redisTemplate.boundValueOps(key).expire(ReuestLimit.time(), TimeUnit.SECONDS);

        value = redisTemplate.boundValueOps(key).get();
        System.out.println("ip:" + ip + " value:" + value);
        if (!StringUtils.isEmpty(value)) {
            if (Integer.parseInt(value) >= ReuestLimit.count()) {
            	logger.debug("ip:" + ip + "超出");
                throw new RequestLimitException(
                        "This request exceeds the access limit，please" + ReuestLimit.time() + "s" + "try again。Please contact the administrator Email:lwq.jorden@gmail.com ");
            }
        }

    }
    
/**
    private void responseResult(HttpServletResponse response, Object result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/xml;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(result.toString());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
*/
    /**
     * 获取客户端ip，已过滤nginx等反向代理
     * 
     * @param request
     * @return
     */
    public static String getRealIp(HttpServletRequest request) {
        if (request == null)
            return null;
        String ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index >= 0)
                return ip.substring(0, index);
            else
                return ip;
        }
        ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip))
            return ip;
        return request.getRemoteAddr();
    }

}
