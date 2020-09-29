package com.example.neo4j;

import com.example.neo4j.controller.PersonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcPersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonController personController;

    @Test
    public void contextLoads() {
        assertThat(personController).isNotNull();
    }

    @Test
    public void getAllPersonsTest() throws Exception {
        mockMvc.perform(get("/api/person/getAllPersons"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("\"Keanu Reeves\"")));
    }

    @Test
    public void getFollowersTest() throws Exception {
        mockMvc.perform(get("/api/person/getFollowers"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("\"Paul Blythe\"")));
    }

}
