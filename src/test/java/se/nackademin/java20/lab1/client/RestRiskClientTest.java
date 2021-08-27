package se.nackademin.java20.lab1.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


/**
 * Created by Ashkan Amiri
 * Date:  2021-08-27
 * Time:  13:08
 * Project: lab1-master
 * Copyright: MIT
 */
class RestRiskClientTest {

	private final String json = "{\"pass\":false}";


	@Test
	void canFetchAnforanden() {
		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = new String("http://localhost:8082");
		RiskClient restRegeringClient = new RestRiskClient(restTemplate, baseUrl);
		Risk r = restRegeringClient.fetchResult();
		System.out.println(r.isPass());
		Assertions.assertTrue(r.isPass());


	}


	@Test
	void deserialize() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Risk risk = objectMapper.readValue(json, Risk.class);

		Assertions.assertFalse(risk.isPass());
	}

	@Test
	void serialize() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		Risk r = new Risk();
		r.setPass(false);

		String jsonObject = objectMapper.writeValueAsString(r);
		System.out.println(jsonObject);
		Assertions.assertEquals(json, jsonObject);
	}

	@Test
	void rest() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> forEntity = restTemplate
				.getForEntity("http://localhost:8082/risk/ashkan", String.class);
		System.out.println(forEntity.getStatusCode());
		System.out.println(forEntity.getBody());
	}
}