package com.vnet.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {

	private static final String USER_NAME = "root";
	private static final String PASSWORD = "tianpc";

	/*
	 * 资源授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String userName = (String)principals.getPrimaryPrincipal();
		System.out.println("资源授权-doGetAuthorizationInfo.userName：" + userName);
		Set<String> roleNames = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();
		roleNames.add("administrator");
		permissions.add("user:create");
		permissions.add("user:update");
		permissions.add("user:delete");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		info.setStringPermissions(permissions);
		return info;
	}

	/*
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		System.out.println("登录验证-doGetAuthenticationInfo.token：" + token.getUsername());
		if (token.getUsername().equals(USER_NAME)) {
			return new SimpleAuthenticationInfo(USER_NAME,
					DigestUtils.md5Hex(PASSWORD), getName());
		} else {
			throw new AuthenticationException();
		}
	}

}