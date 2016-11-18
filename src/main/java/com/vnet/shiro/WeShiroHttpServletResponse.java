/**
 *  工程名：vshare
 *  文件名：WeShiroHttpServletResponse.java
 *  包名：com.vnet.shiro
 *  创建时间：2016年11月18日 下午5:42:12
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 */
package com.vnet.shiro;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpServletResponse;

/**
 *  类名：WeShiroHttpServletResponse
 *  修改记录：// 修改历史记录，包括修改日期、修改者及修改内容
 *  创建时间：2016年11月18日 下午5:42:12
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 *
 *  @version V1.0
 *  @author pengcheng.tian
 */
public class WeShiroHttpServletResponse extends ShiroHttpServletResponse {
	public WeShiroHttpServletResponse(HttpServletResponse wrapped, ServletContext context,
			ShiroHttpServletRequest request) {
		super(wrapped, context, request);
	}

	@Override
	protected String toEncoded(String url, String sessionId) {
		if ((url == null) || (sessionId == null))
			return (url);
		String path = url;
		String query = "";
		String anchor = "";
		int question = url.indexOf('?');
		if (question >= 0) {
			path = url.substring(0, question);
			query = url.substring(question);
		}
		int pound = path.indexOf('#');
		if (pound >= 0) {
			anchor = path.substring(pound);
			path = path.substring(0, pound);
		}
		StringBuilder sb = new StringBuilder(path);
		// 重写toEncoded方法，注释掉这几行代码就不会再生成JESSIONID了。
		// if (sb.length() > 0) { // session id param can't be first.
		// sb.append(";");
		// sb.append(DEFAULT_SESSION_ID_PARAMETER_NAME);
		// sb.append("=");
		// sb.append(sessionId);
		// }
		sb.append(anchor);
		sb.append(query);
		return (sb.toString());
	}
}
