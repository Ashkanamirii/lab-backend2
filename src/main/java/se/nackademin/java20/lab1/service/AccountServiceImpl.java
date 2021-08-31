package se.nackademin.java20.lab1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.nackademin.java20.lab1.client.RiskClient;
import se.nackademin.java20.lab1.domain.Account;
import se.nackademin.java20.lab1.domain.Clients;
import se.nackademin.java20.lab1.domain.CreditAccount;
import se.nackademin.java20.lab1.domain.DebitAccount;
import se.nackademin.java20.lab1.persistance.AccountRepo;
import se.nackademin.java20.lab1.persistance.ClientRepo;
import se.nackademin.java20.lab1.presentation.AccountDTO;

import javax.transaction.Transactional;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-26
 * Time:  07:47
 * Project: lab1-master
 * Copyright: MIT
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {
	private final AccountRepo accountRepo;
	private final ClientRepo clientRepo;
	private final RiskClient riskClient;


	@Transactional
	@Override
	public Account createCreditAccount(CreditAccount credit, Long clientId) {
		Clients client = clientRepo.findById(clientId).get();
		if (riskClient.isPassingCreditCheck(client.getFirstName())) {
			credit.setAccountNumber(credit.accNRGenerator());
			credit.creditCardGenerator();
			Account account = accountRepo.save(credit);
			client.addAccountToClient(account);
//	        clientRepo.save(client);

			return account;
		} else {
			throw new RuntimeException("Could not open account due to failing risk assessment");
		}

	}

	@Transactional
	@Override
	public Account createDebitAccount(DebitAccount debit, Long clientId) {
		Clients client = clientRepo.findById(clientId).get();
		if (riskClient.isPassingCreditCheck(client.getFirstName())) {
			debit.setAccountNumber(debit.accNRGenerator());
			Account account = accountRepo.save(debit);
			client.addAccountToClient(account);
//		clientRepo.save(client);
			return account;
		} else {
			throw new RuntimeException("Could not open account due to failing risk assessment");
		}

	}

	@Transactional
	@Override
	public Account deposit(AccountDTO accountInfo) {
		Clients c = clientRepo.findById(accountInfo.getClientId()).get();
		Account account = accountRepo.findByAccountNumber(accountInfo.getAccountNumber());

		if (c.getAccounts().contains(account)) {
			account.deposit(accountInfo.getAmount());
			return accountRepo.save(account);
		} else {
			throw new RuntimeException("Could not deposit due to failing matching acc number and holder");

		}
	}

	@Transactional
	@Override
	public Account withdraw(AccountDTO accountInfo) {
		Clients c = clientRepo.findById(accountInfo.getClientId()).get();
		Account account = accountRepo.findByAccountNumber(accountInfo.getAccountNumber());

		if (c.getAccounts().contains(account)) {
			account.withdraw(accountInfo.getAmount());
			return accountRepo.save(account);
		} else {
			throw new RuntimeException("Could not withdraw due to failing matching acc number and holder");
		}
	}
}
