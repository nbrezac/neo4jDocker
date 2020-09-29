package com.example.neo4j.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type="PRODUCED")
//@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class ProducedRelationship {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private int on;

    @JsonIgnore
    @StartNode
    private Person person;

    @JsonIgnore
    @EndNode
    private Movie movie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOn() {
        return on;
    }

    public void setOn(int on) {
        this.on = on;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
