package com.restspringboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.restspringboot.models.Person;

@Service
public class PersonService {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public Person findById(String id) {
		logger.info("finding the person by id!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("bruno");
		person.setLastName("silva");
		person.setAdresss("Porto Alegre - Rio Grande do sul");
		person.setGender("male");
		return person;
	}
	
	public List<Person> findAll() {;
		logger.info("finding every person!");
	
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 9;i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}

		return persons;
	}
	
	public Person createPerson(Person person) {
		logger.info("creating one person!");	
		return person;
	}
	
	public Person updatePerson(Person person) {
		logger.info("updating person!");	
		return person;
	}
	
	public void deletePerson(String id) {
		logger.info("deleting one person!");	
	}

	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("mockFirstName: " + i);
		person.setLastName("mockLastName:" + i);
		person.setAdresss("mockAdressName:" + i);
		person.setGender("Male");
		return person;
	}
	
}
