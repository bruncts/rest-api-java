package com.restspringboot.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return DozerMapper.parseObject(entity, PersonVO.class) ;
	}
	
	public List<PersonVO> findAll() {;
		logger.info("finding every person!");
		
		return DozerMapper.parseList(repository.findAll(), PersonVO.class) ;

	}
	
	public PersonVO createPerson(PersonVO personVO) {
		logger.info("creating one person!");	
		var entity = DozerMapper.parseObject(personVO, Person.class);
		var vo = repository.save(entity);
		return DozerMapper.parseObject(vo, PersonVO.class);
	}
	
	public PersonVO updatePerson(PersonVO person) {
		logger.info("updating person!");
		var entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("there is no person with the id: " + person.getId()));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		var vo = repository.save(entity);
		return DozerMapper.parseObject(vo, PersonVO.class);
	}
	
	public void deletePerson(Long id) {
		logger.info("deleting one person!");
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("there is no person with the id: " + id));
		repository.delete(entity);
	}

	
}
