package com.restspringboot.mapper.custum;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.restspringboot.data.vo.v2.PersonVOV2;
import com.restspringboot.models.Person;

@Service
public class PersonMapper {
	public PersonVOV2 convertPersonToVOV2(Person person) {
		var vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setAddress(person.getAddress());
		vo.setGender(person.getGender());
		vo.setBirthday(new Date());
		return vo;
	}
	
	public Person convertVOV2ToPerson(PersonVOV2 person) {
		var entity = new Person();
		entity.setId(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return entity;
	}
}
