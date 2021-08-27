package se.nackademin.java20.lab1.service;

import se.nackademin.java20.lab1.domain.Account;
import se.nackademin.java20.lab1.domain.CreditAccount;
import se.nackademin.java20.lab1.domain.DebitAccount;

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
	Account deposit (long amount , Long accountNumber , Long clientId);
	Account withdraw (long amount , Long accountNumber, Long clientId);
}
