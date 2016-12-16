/**
 *  工程名：vshare
 *  文件名：XsdUserBeanDefinitionParser.java
 *  包名：com.vnet.spring.extend
 *  创建时间：2016年11月29日 下午5:54:41
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 */
package com.vnet.spring.extend;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 *  类名：XsdUserBeanDefinitionParser
 *  修改记录：// 修改历史记录，包括修改日期、修改者及修改内容
 *  创建时间：2016年11月29日 下午5:54:41
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 *
 *  @version V1.0
 *  @author pengcheng.tian
 */
public class XsdUserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	protected Class<XsdUser> getBeanClass(Element element) {
		return XsdUser.class;
	}

	protected void doParse(Element element, BeanDefinitionBuilder bean) {
		String id = element.getAttribute("id");
		String userName = element.getAttribute("userName");
		String email = element.getAttribute("email");

		if (StringUtils.hasText(id)) {
			bean.addPropertyValue("id", id);
		}
		if (StringUtils.hasText(userName)) {
			bean.addPropertyValue("userName", userName);
		}
		if (StringUtils.hasText(email)) {
			bean.addPropertyValue("email", email);
		}
	}

}
