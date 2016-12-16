/**
 *  工程名：vshare
 *  文件名：XsdUser.java
 *  包名：com.vnet.spring.extend
 *  创建时间：2016年11月29日 下午5:54:03
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 */
package com.vnet.spring.extend;
/**
 *  类名：XsdUser
 *  修改记录：// 修改历史记录，包括修改日期、修改者及修改内容
 *  创建时间：2016年11月29日 下午5:54:03
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 *
 *  @version V1.0
 *  @author pengcheng.tian
 */
public class XsdUser {

	private String id;
	private String userName;
	private String email;

	public XsdUser() {
		super();
	}

	public XsdUser(String id, String userName, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
