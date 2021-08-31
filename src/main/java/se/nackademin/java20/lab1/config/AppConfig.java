package se.nackademin.java20.lab1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import se.nackademin.java20.lab1.client.RestRiskClient;
import se.nackademin.java20.lab1.client.Risk;
import se.nackademin.java20.lab1.client.RiskClient;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-30
 * Time:  23:30
 * Project: lab1-master
 * Copyright: MIT
 */
@Configuration
public class AppConfig {
	@Value("${app.risk-service-url}")
	private String riskServiceBaseUrl;


	@Bean
	public RiskClient riskClient() {
		return new RestRiskClient(new RestTemplate(), riskServiceBaseUrl);
	}
}
