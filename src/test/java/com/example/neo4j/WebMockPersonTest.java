package com.example.neo4j;

import com.example.neo4j.controller.PersonController;
import com.example.neo4j.model.Person;
import com.example.neo4j.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
public class WebMockPersonTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonService personService;

    @Test
    public void testGetFollowersWithFakeResponse() throws Exception{
        List<Person> fakeFollowers = new ArrayList<>();
        Person fakeFollower = new Person();
        fakeFollower.setId((long) 1);
        fakeFollower.setBorn(1999);
        fakeFollower.setName("Fake Follower");
        fakeFollowers.add(fakeFollower);


        when(personService.getFollowers()).thenReturn(fakeFollowers);
        mockMvc.perform(get("/api/person/getFollowers"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("\"Fake Follower\"")));

    }

}
