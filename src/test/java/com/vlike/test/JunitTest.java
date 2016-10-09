package com.vlike.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JunitTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	@Test
	public void JTest() throws Exception {
		System.out.println("Junit Test");

		System.out.println("2222222222");

		int a = 0;
		System.out.println(a);
		a++;

		System.out.println(a);
		throw new Exception("主動報錯");
	}

	@Ignore
	@Test
	public void ignoreTest() {
		System.out.println("请忽略我！@Ignore");
	}

	/**
	 * @Test注解方法中抛出了异常，所有的@After注解方法依然会被执行
	 */
	@After
	public void tearDown() {
		System.out.println("After");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass");
	};

	@AfterClass
	public static void afterClass() {
		System.out.println("@AfterClass");
	};

}
