package com.example.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.Fish;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc // sets up the testing class
public class FishControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Fish testFish = new Fish("Maas", "Tuna", 4494);
		String testFishAsJSON = this.mapper.writeValueAsString(testFish);
		RequestBuilder req = post("/createFish").content(testFishAsJSON).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = MockMvcResultMatchers.status().is(201);
		Fish createdDino = new Fish(1, "Maas", "Tuna", 4494);
		String createdDinoAsJSON = this.mapper.writeValueAsString(createdDino);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdDinoAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

}
