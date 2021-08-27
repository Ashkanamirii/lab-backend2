package se.nackademin.java20.lab1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-25
 * Time:  10:52
 * Project: lab1-master
 * Copyright: MIT
 */
@Data
@Entity
@DiscriminatorValue("DA")
public class DebitAccount extends Account {

	@Override
	public long withdraw(long amount) {
		long newBalance = this.balance - amount;
		if (newBalance < 0) throw new IllegalStateException("Balance cannot be less than 0");
		return this.balance =this.balance - amount;
	}

	@Override
	public long deposit(long amount) {
		return this.balance = this.balance + amount;
	}
}
