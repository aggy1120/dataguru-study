package com.zy.ebusiness.chapter1.protocolbuffers.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 生成java数据访问类
 * @author zhangyi
 *
 */
public class GenerateClass {
	
	private Logger logger = LoggerFactory.getLogger(GenerateClass.class);
	
	public static void main(String[] args) throws InterruptedException, IOException {
		String cmd = "protoc.exe --proto_path=F://study//git//dataguru-study//zy-ebusiness//src//main//java//com//zy//ebusiness//chapter1//protocolbuffers//proto "
				+ "--java_out=F://study//git//dataguru-study//zy-ebusiness//src//main//java "
				+ "F://study//git//dataguru-study//zy-ebusiness//src//main//java//com//zy//ebusiness//chapter1//protocolbuffers//proto//person.proto";
		Runtime.getRuntime().exec("F://study//git//dataguru-study//zy-ebusiness//src//main//java//com//zy//ebusiness//chapter1//protocolbuffers//utils//"+cmd).waitFor();//通过执行cmd命令调用protoc.exe程序
	}
}
