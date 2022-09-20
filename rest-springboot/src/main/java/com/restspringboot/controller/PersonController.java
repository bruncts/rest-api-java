package com.restspringboot.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restspringboot.model.Person;
import com.restspringboot.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
//	private static final String template = "Hello, %s!";
//	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private PersonService service;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findPersonByID(@PathParam(value = "id") String id) {
		return service.findById(id);
	}
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return service.findAll();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Person createPerson(@RequestBody Person person) {
		return service.createPerson(person);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Person updatePerson(@RequestBody Person person) {
		return service.updatePerson(person);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deletePerson(@PathParam(value = "id") String id) {
		service.deletePerson(id);
	}

}
