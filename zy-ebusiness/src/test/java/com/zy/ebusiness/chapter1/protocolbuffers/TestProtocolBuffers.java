package com.zy.ebusiness.chapter1.protocolbuffers;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.InvalidProtocolBufferException;
import com.zy.ebusiness.chapter1.protocolbuffers.beans.PersonProtobuf;
import com.zy.ebusiness.chapter1.protocolbuffers.beans.PersonProtobuf.Person;

public class TestProtocolBuffers {
	
	private Logger logger = LoggerFactory.getLogger(TestProtocolBuffers.class);
	
	private Person person;
	
	@Before
	public void init(){
		//构建一个Person对象
        person = PersonProtobuf.Person.newBuilder()
				.setEmail("271777197@qq.com")
				.setId(1)
				.setName("张毅")
				.addPhone(
			            Person.PhoneNumber.newBuilder().setNumber("18611896561")
			                    .setType(Person.PhoneType.HOME).build())
				.build();
	}
	
	@Test
	public void test(){
		System.out.println("打印输出Person对象信息：");
        System.out.println(person);
        System.out.println("Person对象调用toString()方法：");
        System.out.println(person.toString());
 
        System.out.println("Person对象字段是否初始化：" + person.isInitialized());
 
        // 序列号
        System.out.println("Person对象调用toByteString()方法：");
        System.out.println(person.toByteString());
 
        System.out.println("Person对象调用toByteArray()方法:");
        System.out.println(Arrays.toString(person.toByteArray()));
         
        try {
            System.out.println("反序列化后的对象信息：");
            // 反序列化
            Person newPerson = Person.parseFrom(person.toByteArray());
            System.out.println(newPerson);
            newPerson = Person.parseFrom(person.toByteString());
            System.out.println(newPerson);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
	}
}
