package se.nackademin.java20.lab1.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

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
public class Clients {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	@NotNull
	@Column(unique = true, nullable = false)
	private String email;
	private String password;
	private String address;
	private long phone;
	private Date birthDate;


	@Column(columnDefinition = "boolean default false")
	private boolean hasCreditLevel;

	// This Class is not owner of relationship because of that you need to write mappedBy
	@OneToMany
	@JoinTable(name ="clients_accounts",
	joinColumns = @JoinColumn(name ="fk_clients_id"),
	inverseJoinColumns = @JoinColumn(name ="fk_accounts_id"))
	private List<Account> accounts = new ArrayList<>();

	public void addAccountToClient(Account account) {
		this.accounts.add(account);
	}

}
