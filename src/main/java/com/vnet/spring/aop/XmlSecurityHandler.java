package com.vnet.spring.aop;

import org.aspectj.lang.JoinPoint;

public class XmlSecurityHandler {

	/**
	 * 定义Advice，表示我们的Advice应用到哪些Pointcut订阅的Joinpoint上
	 * JoinPoint----参数值和方法名称----
	 */
	public void beforeCheckSecurity(JoinPoint joinPoint) {
		/*System.out.println(joinPoint.getArgs().length);
		for (int i = 0; i < joinPoint.getArgs().length; i++) {
			System.out.println(joinPoint.getArgs()[i]);
		}*/
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("-------beforeCheckSecurity-------");
	}

	public void afterCheckSecurity() {
		System.out.println("-------afterCheckSecurity-------");
	}

}
