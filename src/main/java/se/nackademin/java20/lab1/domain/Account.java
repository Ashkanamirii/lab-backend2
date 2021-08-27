package se.nackademin.java20.lab1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-25
 * Time:  10:51
 * Project: lab1-master
 * Copyright: MIT
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="account_type",
		discriminatorType = DiscriminatorType.STRING)
public abstract class Account {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NonNull
	private long accountNumber;

	@Column(name = "balance")
	protected long balance;

	public Long accNRGenerator() {
		int min = 100000;
		int max = 9999999;

		//Generate random int value from 100000 to 9999999
		System.out.println("Random value in int from "+min+" to "+max+ ":");
		int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		System.out.println(random_int);
		return this.accountNumber = random_int;
	}

	public abstract long withdraw(long amount);
	public abstract long deposit(long amount);

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "clients_id", referencedColumnName = "id")
//	private Clients clients;
}
