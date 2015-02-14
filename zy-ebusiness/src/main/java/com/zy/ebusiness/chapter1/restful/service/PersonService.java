package com.zy.ebusiness.chapter1.restful.service;

import com.zy.ebusiness.chapter1.restful.dto.Person;


public interface PersonService {
	
	public Person getPerson(String name);
	
	public void savePerson(Person person);
	
	public void updatePerson(Person person);
	
	public void deletePerson(String name);
}
