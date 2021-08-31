package se.nackademin.java20.lab1.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-27
 * Time:  13:00
 * Project: lab1-master
 * Copyright: MIT
 */
public class RestRiskClient implements RiskClient {
	private final RestTemplate restTemplate;
	private final String baseUrl;


	public RestRiskClient(RestTemplate restTemplate, String baseUrl) {
		this.restTemplate = restTemplate;
		this.baseUrl = baseUrl;
	}


	@Override
	public boolean isPassingCreditCheck(String userId) {

		final ResponseEntity<RiskDTO> entity = restTemplate.
				getForEntity(baseUrl + "/risk/" + userId, RiskDTO.class);
		if (entity.getStatusCode().is2xxSuccessful()) {
			return entity.getBody().getRisk().isPass();
		}

		throw new RuntimeException("Could not fetch risk assessment!");
	}

}
