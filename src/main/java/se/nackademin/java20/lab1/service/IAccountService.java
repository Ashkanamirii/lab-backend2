package se.nackademin.java20.lab1.service;

import se.nackademin.java20.lab1.domain.Account;
import se.nackademin.java20.lab1.domain.CreditAccount;
import se.nackademin.java20.lab1.domain.DebitAccount;
import se.nackademin.java20.lab1.presentation.AccountDTO;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-25
 * Time:  15:09
 * Project: lab1-master
 * Copyright: MIT
 */
public interface IAccountService {
	Account createCreditAccount(CreditAccount credit , Long clientId);
	Account createDebitAccount(DebitAccount debit ,Long clientId);
	Account deposit (AccountDTO accountInfo);
	Account withdraw (AccountDTO accountInfo);
}
