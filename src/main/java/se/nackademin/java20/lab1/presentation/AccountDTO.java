package se.nackademin.java20.lab1.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-26
 * Time:  14:56
 * Project: lab1-master
 * Copyright: MIT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
	private String accountType;
	private Long amount;
	private Long clientId;
	private Long accountNumber;
}
