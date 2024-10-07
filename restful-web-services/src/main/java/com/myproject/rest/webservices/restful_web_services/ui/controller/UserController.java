package com.myproject.rest.webservices.restful_web_services.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.rest.webservices.restful_web_services.data.repository.UserRepository;
import com.myproject.rest.webservices.restful_web_services.domain.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/users")
	public List<User> getAll(){
		return repository.getAll();
	}
	
	@GetMapping("/users/{id}")
	public User get(@PathVariable int id){
		return repository.get(id);
	}


}
