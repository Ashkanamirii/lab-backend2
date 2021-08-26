package se.nackademin.java20.lab1.service;

import se.nackademin.java20.lab1.domain.Clients;

import java.util.List;
import java.util.UUID;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-26
 * Time:  07:51
 * Project: lab1-master
 * Copyright: MIT
 */
public interface IClientService {
	Clients save(Clients client);
	Clients update(Clients client);
	String deleteById(Long id);
	Clients getById(Long id);
	List<Clients>  getClientList();
	Clients authUser(String email, String password);
}
