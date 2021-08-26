package se.nackademin.java20.lab1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.nackademin.java20.lab1.domain.Account;
import se.nackademin.java20.lab1.domain.Clients;
import se.nackademin.java20.lab1.domain.CreditAccount;
import se.nackademin.java20.lab1.domain.DebitAccount;
import se.nackademin.java20.lab1.persistance.AccountRepo;
import se.nackademin.java20.lab1.persistance.ClientRepo;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-26
 * Time:  07:47
 * Project: lab1-master
 * Copyright: MIT
 */
@Service
@Transactional
public class AccountServiceImpl implements IAccountService{

	@Autowired
	AccountRepo accountRepo;
	@Autowired
	ClientRepo clientRepo;

    @Transactional
	@Override
	public CreditAccount createCreditAccount(CreditAccount credit, Long clientId) {
		Clients client = clientRepo.findById(clientId).get();
		credit.setAccountNumber(credit.accNRGenerator());
		credit.creditCardGenerator();
	    CreditAccount account = accountRepo.save(credit);
	    client.addAccountToClient(account);

		return account;
	}

	@Override
	public DebitAccount createDebitAccount(DebitAccount debit, Long clientId) {
		Clients client = clientRepo.findById(clientId).get();
		debit.setAccountNumber(debit.accNRGenerator());
		DebitAccount account = accountRepo.save(debit);
		client.addAccountToClient(account);
		return account;
	}

	@Override
	public ResponseEntity<?> Deposit(long amount, Long accountId, Long clientId) {
		return null;
	}

	@Override
	public ResponseEntity<?> Withdraw(long amount, Long accountId, Long clientId) {
		return null;
	}
}
