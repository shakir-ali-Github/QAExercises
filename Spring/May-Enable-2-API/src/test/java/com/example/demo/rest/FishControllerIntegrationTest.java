package com.example.demo.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.Fish;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc // sets up the testing class
@Sql(scripts = { "classpath:fish-schema.sql",
"classpath:fish-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
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
		Fish createdFish = new Fish(2, "Maas", "Tuna", 4494);
		String createdFishAsJSON = this.mapper.writeValueAsString(createdFish);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdFishAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testRead() throws Exception {
		List<Fish> fishs = List.of(new Fish(1, "Nestor", "Salmon", 49));
		this.mvc.perform(get("/getFishs")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(fishs)));
	}

	@Test
	void testUpdate() throws Exception {
		Fish updated = new Fish(1, "Tiffany", "Tuna", 4494);
		this.mvc.perform(patch("/updateFish/1?name=Tiffany&species=Tuna&age=4494")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(updated)));
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeFish/1")).andExpect(status().isNoContent());
	}

}
