package com.jorden.li.auth.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.jorden.li.auth.service.AuthService;
import com.jorden.li.commons.bean.IJWTInfo;
import com.jorden.li.commons.bean.JWTInfo;
import com.jorden.li.commons.core.CommonConstants;
import com.jorden.li.commons.core.RsaKeyHelper;
import com.xiaoleilu.hutool.util.ObjectUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @ClassName:  AuthServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: jorden.li
 * @date:   2018年3月16日 下午1:08:57   
 *     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 * Success is never final. Failure is never fatal. Courage is what counts. -Sir Winston Churchill
 */
@Service
public class AuthServiceImpl  implements AuthService{
	
	  private static final RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();
	/**
	 * 
	 *  获取token
	 * <p>Title: auth</p>   
	 * <p>Description: </p>   
	 * @param aq
	 * @return   
	 * @see com.jorden.li.auth.service.AuthService#auth(com.jorden.li.commons.bean.AuthQuery)
	 */
	@Override
	public String auth(String accessKey) {
		int expire =3000;
		String compactJws =null;
		  try {
			
			 compactJws =
			          //返回的字符串便是我们的jwt串了
			          Jwts.builder()
			                  //设置主题
			                  .setSubject(accessKey)
			                  .claim(CommonConstants.JWT_KEY_ADMIN_ID, CommonConstants.JWT_KEY_ADMIN_ID)
			                  .claim(CommonConstants.JWT_KEY_NAME, CommonConstants.JWT_KEY_NAME)
			                  .claim(CommonConstants.JWT_KEY_APP_ID, CommonConstants.JWT_KEY_APP_ID)
			                  .setExpiration(org.joda.time.DateTime.now().plusSeconds(expire).toDate())
			                  //设置算法（必须）
			                  .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey( ResourceUtils.getFile("classpath:client/pri.key")))
			                  //这个是全部设置完成后拼成jwt串的方法
			                  .compact();
			 
			 
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compactJws;
	}
	/** 
	 *    注销token
	 * <p>Title: invalidate</p>   
	 * <p>Description: </p>   
	 * @param token   
	 * @see com.jorden.li.auth.service.AuthService#invalidate(java.lang.String)
	 */
	@Override
	public void invalidate(String token) {
		// TODO Auto-generated method stub
		
	}
	/**
	 *  刷新token
	 * <p>Title: refresh</p>   
	 * <p>Description: </p>   
	 * @param token
	 * @return   
	 * @see com.jorden.li.auth.service.AuthService#refresh(java.lang.String)
	 */
	@Override
	public String refresh(String token) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 获取token信息
	 * <p>Title: getTokenInfo</p>   
	 * <p>Description: </p>   
	 * @param act
	 * @param token
	 * @return   
	 * @see com.jorden.li.auth.service.AuthService#getTokenInfo(java.lang.String, java.lang.String)
	 */
	@Override
	public IJWTInfo getTokenInfo( String token) {
		    
	        Claims body = null;
			try {
				Jws<Claims> jws =	rsaKeyHelper.parserToken(token, ResourceUtils.getFile("classpath:client/pub.key"));
				if(ObjectUtil.isNotNull(jws)){
					body = jws.getBody();
					
					 String adminId = body.get(CommonConstants.JWT_KEY_ADMIN_ID).toString();
				        Long aId = -1L;
				        try {
				            aId = adminId == null || adminId.isEmpty() ? -1L : Long.valueOf(adminId);
				        } catch (Exception e) {
				        }
				        return new JWTInfo(body.getSubject(), adminId,  body.get(CommonConstants.JWT_KEY_NAME).toString(),  CommonConstants.JWT_KEY_APP_ID);
				}else{
					
					return new JWTInfo("NODATAS", "NODATAS", "NODATAS", "NODATAS");
				}
				
			} catch (Exception e1) {
				return new JWTInfo("NODATAS", "NODATAS", "NODATAS", "NODATAS");
			}
			
	       
	         
	}

	

}
