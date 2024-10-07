package com.myproject.rest.webservices.restful_web_services.data.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myproject.rest.webservices.restful_web_services.domain.model.User;

@Component
public class UserRepository {

	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Steven", LocalDate.now().minusYears(30)));
		users.add(new User(1, "Sarah", LocalDate.now().minusYears(25)));
		users.add(new User(1, "James", LocalDate.now().minusYears(35)));
		users.add(new User(1, "Sandra", LocalDate.now().minusYears(30)));
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User get(int id) {
		return users.stream().filter(user -> user.getId() == id).findFirst().get();
	}
	
}
