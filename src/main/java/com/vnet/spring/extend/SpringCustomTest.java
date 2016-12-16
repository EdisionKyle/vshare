/**
 *  工程名：vshare
 *  文件名：SpringCustomTest.java
 *  包名：com.vnet.spring.extend
 *  创建时间：2016年11月29日 下午6:18:47
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 */
package com.vnet.spring.extend;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  类名：SpringCustomTest
 *  修改记录：// 修改历史记录，包括修改日期、修改者及修改内容
 *  创建时间：2016年11月29日 下午6:18:47
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 *
 *  @version V1.0
 *  @author pengcheng.tian
 */
public class SpringCustomTest {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext-extend.xml");
		XsdUser user = (XsdUser) ctx.getBean("testBean");
		System.out.println(user.getUserName() + " -- " + user.getEmail());
		ctx.close();
	}

}
