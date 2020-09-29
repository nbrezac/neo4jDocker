package com.example.neo4j.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private int released;

    private String tagline;

    @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
    private Set<Person> persons;
}
