package com.zy.ebusiness.chapter1.protocol.service;

import com.zy.ebusiness.chapter1.protocolbuffers.beans.PersonProtobuf;
import com.zy.ebusiness.chapter1.protocolbuffers.beans.PersonProtobuf.Person;

public class PersonServiceImp implements PersonService{

	@Override
	public byte[] findPerson() {
		// TODO Auto-generated method stub
		Person  person = PersonProtobuf.Person.newBuilder()
				.setEmail("271777197@qq.com")
				.setId(1)
				.setName("张毅")
				.addPhone(
			            Person.PhoneNumber.newBuilder().setNumber("18611896561")
			                    .setType(Person.PhoneType.HOME).build())
				.build();
		
		return person.toByteArray();
	}
	
}
