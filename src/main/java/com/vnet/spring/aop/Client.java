package com.vnet.spring.aop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ConfigurableApplicationContext factory = new ClassPathXmlApplicationContext(
				"classpath*:*applicationContext.xml");
//		UserManager userManager = (UserManager) factory.getBean("userManagerImpl");
		UserManagerImpl userManager = (UserManagerImpl) factory.getBean("userManagerImpl");
		userManager.addUser("张三", "123");
		System.out.println("***********");
		userManager.findUserById(1);
		factory.close();
	}
}
// 网上看了学的，才知道是aspectj出现的问题，其实也是spring framework 与jdk6.0不兼容的问题，如果换成jdk5.0就好了，
// 但是已经习惯新的jdk6.0了，于是只能升级一下spring framework了，换了spring相关的所有jar包，问题就解决的了
// http://www.blogjava.net/mingruofei/articles/314414.html