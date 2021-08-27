package se.nackademin.java20.lab1.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-27
 * Time:  13:47
 * Project: lab1-master
 * Copyright: MIT
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskDTO {
	private final Risk risk;

	@JsonCreator
	public RiskDTO(@JsonProperty("pass") Risk risk) {
		this.risk = risk;
	}

	public Risk getRisk() {
		return risk;
	}
}
