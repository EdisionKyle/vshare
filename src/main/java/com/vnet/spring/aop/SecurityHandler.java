package com.vnet.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component //for auto scan
@Aspect //for aop
@Order(0) // execute before @Transactional
public class SecurityHandler {

	/**
	 * 定义Pointcut，Pointcut的名称为anyMethod()，此方法没有返回值和参数 该方法就是一个标识，不进行调用
	 */
	@Pointcut("execution(* com.vnet.spring.aop..*(..))")
	private void anyMethod() {
	}

	/**
	 * 定义Advice，表示我们的Advice应用到哪些Pointcut订阅的Joinpoint上
	 */
	@Before("anyMethod()")
	public void beforeCheckSecurity() {
		System.out.println("-------beforeCheckSecurity-------");
	}

	@After("anyMethod()")
	public void afterCheckSecurity() {
		System.out.println("-------afterCheckSecurity-------");
	}

}
