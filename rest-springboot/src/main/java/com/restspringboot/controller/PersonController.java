package com.restspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restspringboot.data.vo.v1.PersonVO;
import com.restspringboot.data.vo.v2.PersonVOV2;
import com.restspringboot.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
//	private static final String template = "Hello, %s!";
//	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private PersonService service;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findPersonByID(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll() {
		return service.findAll();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO createPerson(@RequestBody PersonVO PersonVO) {
		return service.createPerson(PersonVO);
	}
	
	@PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV2 createPerson(@RequestBody PersonVOV2 PersonVOV2) {
		return service.createPersonV2(PersonVOV2);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO updatePerson(@RequestBody PersonVO PersonVO) {
		return service.updatePerson(PersonVO);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long id) {
		service.deletePerson(id);
		return ResponseEntity.noContent().build();
	}

}
