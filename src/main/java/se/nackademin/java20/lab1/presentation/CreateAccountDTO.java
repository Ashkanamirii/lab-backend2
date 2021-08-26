package se.nackademin.java20.lab1.presentation;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-26
 * Time:  14:56
 * Project: lab1-master
 * Copyright: MIT
 */
public class CreateAccountDTO {
	private String accountType;
	private Long balance;
	private Long clientId;

	public CreateAccountDTO(String accountType, Long balance, Long clientId) {
		this.accountType = accountType;
		this.balance = balance;
		this.clientId = clientId;
	}

	public CreateAccountDTO() {
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
}
