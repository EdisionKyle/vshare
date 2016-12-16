/**
 *  工程名：vshare
 *  文件名：XsdNamespaceHandler.java
 *  包名：com.vnet.spring.extend
 *  创建时间：2016年11月29日 下午5:56:50
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 */
package com.vnet.spring.extend;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 *  类名：XsdNamespaceHandler
 *  修改记录：// 修改历史记录，包括修改日期、修改者及修改内容
 *  创建时间：2016年11月29日 下午5:56:50
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 *
 *  @version V1.0
 *  @author pengcheng.tian
 */
public class XsdNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		registerBeanDefinitionParser("xsduser", new XsdUserBeanDefinitionParser());
	}

}
