package com.restspringboot.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restspringboot.controller.PersonController;
import com.restspringboot.data.vo.v1.PersonVO;
import com.restspringboot.exceptions.ResourceNotFoundException;
import com.restspringboot.mapper.DozerMapper;
import com.restspringboot.models.Person;
import com.restspringboot.repositories.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
		
	public PersonVO findById(Long id) {
		logger.info("finding the person by id!");
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("there is no person with the id: " + id));
		var vo = DozerMapper.parseObject(entity, PersonVO.class) ;
		vo.add(linkTo(methodOn(PersonController.class).findPersonByID(id)).withSelfRel());
		return vo;
	}
	
	public List<PersonVO> findAll() {;
		logger.info("finding every person!");
		
		var persons = DozerMapper.parseList(repository.findAll(), PersonVO.class) ;
		persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findPersonByID(p.getKey())).withSelfRel()));
		return persons;
	}
	
	public PersonVO createPerson(PersonVO personVO) {
		logger.info("creating one person!");	
		var entity = DozerMapper.parseObject(personVO, Person.class);
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findPersonByID(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public PersonVO updatePerson(PersonVO person) {
		logger.info("updating person!");
		var entity = repository.findById(person.getKey()).orElseThrow(()-> new ResourceNotFoundException("there is no person with the id: " + person.getKey()));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findPersonByID(vo.getKey())).withSelfRel());
		return vo;

	}
	
	public void deletePerson(Long id) {
		logger.info("deleting one person!");
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("there is no person with the id: " + id));
		repository.delete(entity);
	}

	
}
