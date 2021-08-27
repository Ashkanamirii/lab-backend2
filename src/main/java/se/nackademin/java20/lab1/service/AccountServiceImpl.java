package se.nackademin.java20.lab1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nackademin.java20.lab1.domain.Account;
import se.nackademin.java20.lab1.domain.Clients;
import se.nackademin.java20.lab1.domain.CreditAccount;
import se.nackademin.java20.lab1.domain.DebitAccount;
import se.nackademin.java20.lab1.persistance.AccountRepo;
import se.nackademin.java20.lab1.persistance.ClientRepo;

import javax.transaction.Transactional;

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
	@Transactional
	@Override
	public DebitAccount createDebitAccount(DebitAccount debit, Long clientId) {
		Clients client = clientRepo.findById(clientId).get();
		debit.setAccountNumber(debit.accNRGenerator());
		DebitAccount account = accountRepo.save(debit);
		client.addAccountToClient(account);
		return account;
	}
	@Transactional
	@Override
	public Account deposit(long amount, Long accountNumber, Long clientId) {
		Clients c = clientRepo.findById(clientId).get();
		Account account = accountRepo.findByAccountNumber(accountNumber);

		if (c.getAccounts().contains(account)){
			 account.deposit(amount);
			return accountRepo.save(account);
		}
    	return null;
	}
	@Transactional
	@Override
	public Account withdraw(long amount, Long accountNumber, Long clientId) {
		Clients c = clientRepo.findById(clientId).get();
		Account account = accountRepo.findByAccountNumber(accountNumber);

		if (c.getAccounts().contains(account)){
			account.withdraw(amount);
			return accountRepo.save(account);
		}
		return null;
	}


//	public long withdraw(long amount , long balance) {
//		if (amount > balance) throw new IllegalStateException("Your amount must be less than your balance");
//		long newBalance = balance - amount;
//		if (newBalance <= 0) throw new IllegalStateException("Balance cannot be less than 0");
//		return balance - amount;
//	}
//
//
//	public long deposit(long amount, long balance) {
//		if (amount <= 0) throw new IllegalStateException("Amount can not be 0 and less than it");
//		return balance + amount;
//	}
}
