package se.nackademin.java20.lab1.service;

import org.springframework.http.ResponseEntity;
import se.nackademin.java20.lab1.domain.CreditAccount;
import se.nackademin.java20.lab1.domain.DebitAccount;

import java.util.UUID;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-25
 * Time:  15:09
 * Project: lab1-master
 * Copyright: MIT
 */
public interface IAccountService {
	CreditAccount createCreditAccount(CreditAccount credit , Long clientId);
	DebitAccount createDebitAccount(DebitAccount debit ,Long clientId);
	ResponseEntity<?> Deposit (long amount , Long accountId, Long clientId);
	ResponseEntity<?> Withdraw (long amount , Long accountId, Long clientId);
}
