package com.jorden.li.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jorden.li.auth.service.RequestLimitService;
import com.xiaoleilu.hutool.json.JSONObject;
import com.xiaoleilu.hutool.json.JSONUtil;

/**
 * 
 * @ClassName: RequestLimitServiceImpl
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: jorden.li
 * @date: 2018年3月23日 下午2:21:09
 * 
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. Success is never
 *             final. Failure is never fatal. Courage is what counts. -Sir
 *             Winston Churchill
 */
@Service
public class RequestLimitServiceImpl implements RequestLimitService {

	@Autowired
	RedisTemplate<String, String> redisTemplate;

	/**
	 * 
	 * 
	 * <p>
	 * Title: isAccess
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param key
	 * @return
	 * @see com.jorden.li.auth.service.RequestLimitService#isAccess(java.lang.String)
	 */
	@Override
	public boolean isAccess(String parmJson) {
		// 3秒访问10次
		JSONObject parseobj = JSONUtil.parseObj(parmJson);

		JSONObject json = JSONUtil.createObj();
		String key = parseobj.getStr("key");
		Integer frequency = this.get(key);
		if (frequency == 0) {
			json.remove(key);
			this.set(key, json.toString());
		} else {
			Long fristTime = Long.valueOf(parseobj.get("fristTime").toString());
			// 1秒(s)=1000毫秒(ms)

			Long currentTime = System.currentTimeMillis();
			fristTime = fristTime + 1000 * 3;
			// 是可以访问
			if (currentTime <= fristTime) {
				return true;
			}
			return false;
		}

		return false;
	}

	/**
	 * 
	 * @Title: get @Description: TODO(这里用一句话描述这个方法的作用) @param: @param
	 * key @param: @param hashKey @param: @return @return: Integer @throws
	 */
	public Integer get(String key) {
		String val = redisTemplate.boundValueOps(key).get();
		if (StringUtils.isEmpty(val)) {
			return 0;
		}

		return Integer.parseInt(val);
	}

	public void set(String key, String value) {
		redisTemplate.boundValueOps(key).set(value);

	}

	/**
	 * 
	 * @Title: clear @Description: TODO(这里用一句话描述这个方法的作用) @param: @param
	 * key @param: @param hashKey @return: void @throws
	 */
	public void clear(String key, String hashKey) {
		redisTemplate.opsForHash().delete(key, hashKey);
	}

}
