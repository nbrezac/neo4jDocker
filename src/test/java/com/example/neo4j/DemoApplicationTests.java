package com.example.neo4j;

import com.example.neo4j.controller.MovieController;
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
class DemoApplicationTests {

	@Autowired
	MovieController movieController;

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertThat(movieController).isNotNull();
	}

	@Test
	public void testGetAllMoviesResponse() throws Exception {
		assertThat(this.mockMvc.perform(get("/api/movie"))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("\"The Matrix\""))));
	}

}
