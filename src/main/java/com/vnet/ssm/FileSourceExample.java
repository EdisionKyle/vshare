package com.vnet.ssm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

public class FileSourceExample {

	public static void main(String[] args) {
		try {
			String filePath = "D:/res/spring.txt";
			// 使用系统文件路径方式加载文件
			Resource res1 = new FileSystemResource(filePath);
			// 使用类路径方式加载文件
			Resource res2 = new ClassPathResource("jdbc.properties");
			InputStream ins1 = res1.getInputStream();
			InputStream ins2 = res2.getInputStream();
			System.out.println("res1:" + res1.getFilename());
			byte b1[] = new byte[1024];
			ins1.read(b1);
			System.out.println(new String(b1));
			System.out.println("************分割***********");
			System.out.println("res2:" + res2.getFilename());
			byte b2[] = new byte[1024];
			ins2.read(b2);
			System.out.println(new String(b2));
			ins1.close();
			ins2.close();
			System.out.println("************分割***********");
			File file = ResourceUtils.getFile("classpath:jdbc.properties");
			System.out.println(file.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
