package com.jorden.li.job;

import org.springframework.stereotype.Service;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;

/**
 * **************************************************************** Java Lib For Android, Powered By jorden.li Copyright
 * (c) 2001-2014 Digital Telemedia Co.,Ltd https://jordenlwq.github.io/ Package: com.jorden.li.job Filename:
 * SayHiHoHandler.java Description: TODO(用一句话描述该文件做什么) Copyright: Copyright (c) 2001-2014 Company: Digital Telemedia
 * Co.,Ltd
 * 
 * @author: jorden.li
 * @version: 1.0.0 Create at: 2017年12月28日 下午12:03:34 Revision: 2017年12月28日 下午12:03:34 - first revision
 */
@com.xxl.job.core.handler.annotation.JobHander(value = "SayHiHoHandler")
@Service
public class SayHiHoHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        System.out.println("params: " + params);
        return new ReturnT<String>(200, "执行成功");
    }

}
