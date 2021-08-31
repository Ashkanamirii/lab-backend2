package se.nackademin.java20.lab1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.nackademin.java20.lab1.domain.Clients;
import se.nackademin.java20.lab1.service.IClientService;

import java.util.List;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-26
 * Time:  08:01
 * Project: lab1-master
 * Copyright: MIT
 */

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {

	@Autowired
	IClientService clientService;

	@PostMapping("/save")
    public Clients createNewClient(@RequestBody Clients client) {
       return clientService.save(client);
   }

	@GetMapping("/getAll")
	public List<Clients> getAllClient() {
		return  clientService.getClientList();
	}

	@GetMapping("/getById/{id}")
	public Clients getById(@PathVariable(name = "id") Long id) {
		return  clientService.getById(id);
	}

	@GetMapping("/auth")
	public ResponseEntity<Clients> authUser(@RequestParam String email,
	                                        @RequestParam String password) {
		Clients c = clientService.authUser(email, password);

		return ResponseEntity.ok(c);
	}

}
