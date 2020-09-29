package com.example.neo4j.controller;

import com.example.neo4j.DemoApplication;
import com.example.neo4j.model.Person;
import com.example.neo4j.model.ProducedRelationship;
import com.example.neo4j.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    PersonService personService;

    @GetMapping
    @RequestMapping(value = "/getAllPersons")
    public @ResponseBody List<Person> getAllPersons() {
        logger.debug("getAllPersons called!");
        return personService.getAllPersons();
    }

    @GetMapping
    @RequestMapping(value = "/getFollowers")
    public @ResponseBody List<Person> getFollowers() {
        return personService.getFollowers();
    }

    @PostMapping
    @RequestMapping(value = "/savePerson")
    public @ResponseBody Person savePerson(@RequestBody final Person person) {
        return personService.savePerson(person);
    }

    @GetMapping
    @RequestMapping(value = "/getProducedOn")
    public @ResponseBody List<ProducedRelationship> getProducedOn(@RequestParam int producedOn) {
        return personService.getProducedOn(producedOn);
    }

    @GetMapping
    @RequestMapping(value = "/getPersonByName")
    public @ResponseBody Person getPersonByName(@RequestParam String name) {
        return personService.getPersonByName(name);
    }

}
