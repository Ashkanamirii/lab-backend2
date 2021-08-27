package se.nackademin.java20.lab1.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-27
 * Time:  14:10
 * Project: lab1-master
 * Copyright: MIT
 */
class RiskDTOTest {

	private static final String json = "{\"pass\":true}";

	@Test
	void canDeserializeJson() throws JsonProcessingException {
		RiskDTO riskDTO = new ObjectMapper().readValue(json, RiskDTO.class);
		assertTrue(riskDTO.getRisk().isPass());
	}
}