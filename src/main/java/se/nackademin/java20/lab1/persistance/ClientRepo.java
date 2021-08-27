package se.nackademin.java20.lab1.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.nackademin.java20.lab1.domain.Clients;

import java.util.UUID;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-26
 * Time:  07:48
 * Project: lab1-master
 * Copyright: MIT
 */
@Repository
public interface ClientRepo extends JpaRepository<Clients, Long> {
	Clients findByEmail(String email);

}
