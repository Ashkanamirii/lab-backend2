package se.nackademin.java20.lab1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.nackademin.java20.lab1.domain.Clients;
import se.nackademin.java20.lab1.persistance.ClientRepo;

import java.util.List;
import java.util.UUID;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-26
 * Time:  07:58
 * Project: lab1-master
 * Copyright: MIT
 */
@Service
public class ClientServiceImpl implements IClientService{
	@Autowired
	ClientRepo clientRepo;

	@Override
	public Clients save(Clients client) {
		return clientRepo.save(client);
	}

	@Override
	public Clients update(Clients client) {
		return clientRepo.save(client);
	}

	@Override
	public String deleteById(Long id) {
		 clientRepo.deleteById(id);
		return "Client has been deleted with id " + id;
	}

	@Override
	public Clients getById(Long id) {
		return clientRepo.getById(id);
	}

	@Override
	public List<Clients> getClientList() {
		return clientRepo.findAll();
	}

	@Override
	public Clients authUser(String email, String password) {
		return null;
	}

}
