package com.example.neo4j.repository;

import com.example.neo4j.model.Person;
import com.example.neo4j.model.ProducedRelationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query("MATCH (p:Person)-[r:FOLLOWS]->(d:Person) RETURN p")
    List<Person> getFollowers();

    @Query("match (a:Person{name:\"Neven\"})-[r:PRODUCED{on:$producedOn}]->(b:Movie) return a,r,b")
    List<ProducedRelationship> getProducedOn(@Param("producedOn") int producedOn);

    @Query("MATCH (p:Person) where p.name = $name return p")
    Person getPersonByName(@Param("name") String name);

}
