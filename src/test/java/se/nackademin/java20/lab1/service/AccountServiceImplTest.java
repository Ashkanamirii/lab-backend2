package se.nackademin.java20.lab1.service;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-30
 * Time:  20:39
 * Project: lab1-master
 * Copyright: MIT
 */
@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@Testcontainers
@ContextConfiguration(initializers = AccountServiceImplTest.Lab1ApplicationTestsContextInitializer.class)
@AutoConfigureMockMvc
class AccountServiceImplTest {
	@Container
	private static final MySQLContainer db = new MySQLContainer("mysql:8.0.26").withPassword("password");

	WireMockServer wiremock = new WireMockServer();

	@Autowired
	MockMvc mockMvc;

	@BeforeEach
	public void before() {
		wiremock.start();
	}

	@AfterEach
	public void after() {
		wiremock.stop();
	}
	@Test
	void shouldOpenAccountWithZeroBalance() throws Exception {
		final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/account/create"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrlPattern("/bank/dan/account/{[0-9]*}"))
				.andReturn();

		final String redirectedUrl = mvcResult.getResponse().getRedirectedUrl();
		final String[] split = redirectedUrl.split("/");
		long accountId = Long.parseLong(split[split.length - 1]);

		mockMvc.perform(MockMvcRequestBuilders.get(redirectedUrl))
				.andExpect(status().isOk())
				.andExpect(model().attribute("balance", 0L))
				.andExpect(model().attribute("userId", "dan"))
				.andExpect(model().attribute("accountId", accountId));
	}

	@Test
	void createCreditAccount() {
	}

	@Test
	void createDebitAccount() {
	}

	@Test
	void deposit() {
	}

	@Test
	void withdraw() {
	}
	public static class Lab1ApplicationTestsContextInitializer
			implements ApplicationContextInitializer<ConfigurableApplicationContext> {

		@Override
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			String host = db.getJdbcUrl();
			TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
					configurableApplicationContext,
					"spring.datasource.url=" + host, "flyway.url=" + host);

		}
	}
}