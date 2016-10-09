package com.vnet.spring.aop;

public class CglibTest {

	public static void main(String[] args) {
		CglibProxy<UserManagerImpl> proxy = new CglibProxy<UserManagerImpl>();
		UserManagerImpl proxyImpl = (UserManagerImpl)proxy.getProxy(UserManagerImpl.class);
		proxyImpl.addUser("万里独行", "Tpc06080204@$");
	}

}
