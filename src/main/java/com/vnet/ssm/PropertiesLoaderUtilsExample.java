package com.vnet.ssm;

import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesLoaderUtilsExample {
	public static void main(String[] args) throws Throwable {
		// ① jdbc.properties 是位于类路径下的文件
		Properties props = PropertiesLoaderUtils
				.loadAllProperties("jdbc.properties");
		System.out.println(props.getProperty("jdbc.driverClassName"));
		System.out.println(props.get("jdbc.url"));
	}
}
