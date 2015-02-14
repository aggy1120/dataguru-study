package com.zy.ebusiness.chapter1.restful.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.zy.ebusiness.chapter1.restful.dto.Person;

@Component
public class PersonServiceImp implements PersonService{
	
	private Logger logger = LoggerFactory.getLogger(PersonServiceImp.class);
	
	@Override
	public Person getPerson(String name) {
		// TODO Auto-generated method stub
		logger.info("getPerson by name..."+name);
		Person person = new Person();
		person.setAddress("abc");
		person.setName("zhangyi");
		person.setPhoneNumber("18611896561");
		return person;
	}

	@Override
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		logger.info("savePerson...");
		
	}

	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		logger.info("updatePerson...");
		
	}

	@Override
	public void deletePerson(String name) {
		// TODO Auto-generated method stub
		logger.info("deletePerson by name..."+name);
		
	}

}
