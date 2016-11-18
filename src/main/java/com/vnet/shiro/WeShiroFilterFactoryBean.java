/**
 *  工程名：vshare
 *  文件名：WeShiroFilterFactoryBean.java
 *  包名：com.vnet.shiro
 *  创建时间：2016年11月18日 下午5:43:36
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 */
package com.vnet.shiro;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.beans.factory.BeanInitializationException;

/**
 *  类名：WeShiroFilterFactoryBean
 *  修改记录：// 修改历史记录，包括修改日期、修改者及修改内容
 *  创建时间：2016年11月18日 下午5:43:36
 *  Copyright (C) 2016, tianpc0318@163.com All Rights Reserved.
 *
 *  @version V1.0
 *  @author pengcheng.tian
 */
public class WeShiroFilterFactoryBean extends ShiroFilterFactoryBean {

	@Override
	public Class<WeSpringShiroFilter> getObjectType() {
		return WeSpringShiroFilter.class;
	}

	@Override
	protected AbstractShiroFilter createInstance() throws Exception {

		SecurityManager securityManager = getSecurityManager();
		if (securityManager == null) {
			String msg = "SecurityManager property must be set.";
			throw new BeanInitializationException(msg);
		}

		if (!(securityManager instanceof WebSecurityManager)) {
			String msg = "The security manager does not implement the WebSecurityManager interface.";
			throw new BeanInitializationException(msg);
		}
		FilterChainManager manager = createFilterChainManager();

		PathMatchingFilterChainResolver chainResolver = new PathMatchingFilterChainResolver();
		chainResolver.setFilterChainManager(manager);

		return new WeSpringShiroFilter((WebSecurityManager) securityManager, chainResolver);
	}

	private static final class WeSpringShiroFilter extends AbstractShiroFilter {

		protected WeSpringShiroFilter(WebSecurityManager webSecurityManager, FilterChainResolver resolver) {
			super();
			if (webSecurityManager == null) {
				throw new IllegalArgumentException("WebSecurityManager property cannot be null.");
			}
			setSecurityManager(webSecurityManager);
			if (resolver != null) {
				setFilterChainResolver(resolver);
			}
		}

		@Override
		protected ServletResponse wrapServletResponse(HttpServletResponse orig, ShiroHttpServletRequest request) {
			return new WeShiroHttpServletResponse(orig, getServletContext(), request);
		}
	}

}
