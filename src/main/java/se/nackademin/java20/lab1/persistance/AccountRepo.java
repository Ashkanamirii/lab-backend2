package se.nackademin.java20.lab1.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.nackademin.java20.lab1.domain.Account;

import java.util.UUID;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-26
 * Time:  07:51
 * Project: lab1-master
 * Copyright: MIT
 */
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	Account findByAccountNumber(long accountNumber);
}
