/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.jorden.li.model;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * **************************************************************** Java Lib For Android, Powered By jorden.li Copyright
 * (c) 2001-2014 Digital Telemedia Co.,Ltd https://jordenlwq.github.io/ Package: com.jorden.li.model Filename:
 * UserInfo.java Description: TODO(用一句话描述该文件做什么) Copyright: Copyright (c) 2001-2014 Company: Digital Telemedia Co.,Ltd
 * 
 * @author: jorden.li
 * @version: 1.0.0 Create at: 2017年12月29日 下午1:46:50 Revision: 2017年12月29日 下午1:46:50 - first revision
 */
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_info")
@Getter
@Setter
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "usertype")
    private String userType;
    @Column(name = "enabled")
    private Integer enabled;
    @Column(name = "qq")
    private String qq;
    @Column(name = "email")
    private String tel;
    @Column(name = "email")
    private String email;

}
