package com.restspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restspringboot.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
