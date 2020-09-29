package com.example.neo4j.service;

import com.example.neo4j.model.Person;
import com.example.neo4j.model.ProducedRelationship;
import com.example.neo4j.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    public List<Person> getFollowers() {
        return personRepository.getFollowers();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public List<ProducedRelationship> getProducedOn(int producedOn) {
        return personRepository.getProducedOn(producedOn);
    }

    public Person getPersonByName(String name) {
        return personRepository.getPersonByName(name);
    }


}
