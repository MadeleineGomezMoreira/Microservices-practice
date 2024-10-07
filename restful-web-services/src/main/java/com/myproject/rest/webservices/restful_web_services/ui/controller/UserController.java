package com.myproject.rest.webservices.restful_web_services.ui.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myproject.rest.webservices.restful_web_services.data.repository.UserRepository;
import com.myproject.rest.webservices.restful_web_services.domain.model.User;

import jakarta.validation.Valid;


@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping("/users")
	public List<User> getAll() {
		return repository.getAll();
	}

	@GetMapping("/users/{id}")
	public User get(@PathVariable int id) {
		return repository.get(id);
	}

	@Validated
	@PostMapping("/users")
	public ResponseEntity<User> save(@Valid @RequestBody User newUser) {
		User saved = repository.save(newUser);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		repository.delete(id);
	}

}
