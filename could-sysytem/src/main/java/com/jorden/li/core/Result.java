package com.jorden.li.core;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * ****************************************************************
 *
 *    Java Lib For Android, Powered By jorden.li
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    https://jordenlwq.github.io/
 *    Package:     com.jorden.li.core
 *    Filename:    Result.java
 *    Description: TODO(用一句话描述该文件做什么)
 *    Copyright:   Copyright (c) 2001-2014
 *    Company:     Digital Telemedia Co.,Ltd
 *    @author:     jorden.li
 *    @version:    1.0.0
 *    Create at:   2017年12月29日 下午5:16:03
 *    Revision:
 *    2017年12月29日 下午5:16:03
 *        - first revision
 *
 ****************************************************************
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result implements Serializable {
  
    private String code;
    private String message;
    private Object data;
    

   

}
