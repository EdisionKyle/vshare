package com.vnet.ssm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

public class FileCopyUtilsExample {
	public static void main(String[] args) throws Throwable {
		Resource res = new ClassPathResource("jdbc.properties");
		// 将文件内容拷贝到一个 byte[] 中
		byte[] fileData = FileCopyUtils.copyToByteArray(res.getFile());
		System.out.println(new String(fileData));
		// 将文件内容拷贝到一个 String 中
		String fileStr = FileCopyUtils.copyToString(new FileReader(res
				.getFile()));
		System.out.println(fileStr);
		// 将文件内容拷贝到另一个目标文件
		FileCopyUtils.copy(res.getFile(), new File(res.getFile().getParent()
				+ "/file2.txt"));
		// 将文件内容拷贝到一个输出流中
		OutputStream os = new ByteArrayOutputStream();
		FileCopyUtils.copy(res.getInputStream(), os);

	}
}
