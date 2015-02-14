package com.zy.ebusiness.chapter1.restful.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zy.ebusiness.chapter1.restful.dto.Person;
import com.zy.ebusiness.chapter1.restful.service.PersonService;

@Controller
@RequestMapping(value="/restful")
public class RestFulController {
	
	private Logger logger = LoggerFactory.getLogger(RestFulController.class);
	
	@Autowired
	private PersonService personService;
	
	/*@RequestMapping(value="person",method=RequestMethod.GET)
	@ResponseBody
	public String getPerson(){
		Person person = personService.getPerson("");
		return JSON.toJSONString(person);
	}*/
	
	@RequestMapping(value="/person/{name}",method=RequestMethod.GET)
	@ResponseBody
	public String getPerson(@PathVariable String name){
		Person person = personService.getPerson(name);
		return JSON.toJSONString(person);
	}
	
	
    @RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")  
    public @ResponseBody  
    String say(@PathVariable(value = "msg") String msg) {  
        return "{\"msg\":\"you say:'" + msg + "'\"}";  
    }
	
	@RequestMapping(value="/person/{name}",method=RequestMethod.PUT)
	@ResponseBody
	public String putPerson(@PathVariable String name,Person person){
		personService.updatePerson(person);
		return "success";
	}
	
	@RequestMapping(value="/person/{name}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deletePerson(@PathVariable String name){
		personService.deletePerson(name);
		return "success";
	}
	
	@RequestMapping(value="/person",method=RequestMethod.POST)
	@ResponseBody
	public String savePerson(Person person){
		personService.savePerson(person);
		return "success";
	}
	
}
