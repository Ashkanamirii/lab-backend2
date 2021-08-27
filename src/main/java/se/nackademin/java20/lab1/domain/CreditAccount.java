package se.nackademin.java20.lab1.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Random;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-25
 * Time:  10:52
 * Project: lab1-master
 * Copyright: MIT
 */

@Data
@Entity
@DiscriminatorValue("CC")
public class CreditAccount extends Account {

	@Column
	protected String creditCard;


	public String creditCardGenerator() {
		 this.creditCard = "CC";
		Random value = new Random();

		//Generate two values to append to 'BE'
		int r1 = value.nextInt(10);
		int r2 = value.nextInt(10);
		this.creditCard += Integer.toString(r1) + Integer.toString(r2) + " ";

		int count = 0;
		int n = 0;
		for(int i =0; i < 12;i++)
		{
			if(count == 4)
			{
				this.creditCard += " ";
				count =0;
			}
			else
				n = value.nextInt(10);
			this.creditCard += Integer.toString(n);
			count++;

		}
		return this.creditCard;
	}

	@Override
	public long withdraw(long amount) {
		if (amount > balance) throw new IllegalStateException("Your amount must be less than your balance");
		long newBalance = balance - amount;
		if (newBalance <= 0) throw new IllegalStateException("Balance cannot be less than 0");
		return this.balance = this.balance - amount;
	}

	@Override
	public long deposit(long amount) {
		if (amount <= 0) throw new IllegalStateException("Amount can not be 0 and less than it");
		return this.balance = this.balance + amount;
	}

}
