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
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int born;

    @Relationship(type = "PRODUCED")
    private Set<ProducedRelationship> producedRelationships;
}
