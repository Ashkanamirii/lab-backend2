package se.nackademin.java20.lab1.client;

import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-27
 * Time:  13:00
 * Project: lab1-master
 * Copyright: MIT
 */
public class RestRiskClient  implements RiskClient{
	private final RestTemplate restTemplate;
	private final String baseUrl;

	private static final String path = "/risk/ashkan";

	public RestRiskClient(RestTemplate restTemplate, String baseUrl) {
		this.restTemplate = restTemplate;
		this.baseUrl = baseUrl;
	}


	@Override
	public Risk fetchResult() {
		return Objects.requireNonNull(restTemplate.getForEntity(baseUrl + path, RiskDTO.class)
				.getBody()).getRisk();
	}
}
