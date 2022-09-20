package com.restspringboot.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restspringboot.exceptions.ResourceNotFoundException;
import com.restspringboot.models.Person;
import com.restspringboot.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
		
	public Person findById(Long id) {
		logger.info("finding the person by id!");
//		Person person = new Person();
//		person.setId(counter.incrementAndGet());
//		person.setFirstName("bruno");
//		person.setLastName("silva");
//		person.setAdresss("Porto Alegre - Rio Grande do sul");
//		person.setGender("male");
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("there is no person with the id: " + id));
	}
	
	public List<Person> findAll() {;
		logger.info("finding every person!");
		
		return repository.findAll();

	}
	
	public Person createPerson(Person person) {
		logger.info("creating one person!");	
		return repository.save(person);
	}
	
	public Person updatePerson(Person person) {
		logger.info("updating person!");
		
		Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("there is no person with the id: " + person.getId()));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdresss(person.getAdresss());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void deletePerson(Long id) {
		logger.info("deleting one person!");
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("there is no person with the id: " + id));
		repository.delete(entity);
	}

	
}
