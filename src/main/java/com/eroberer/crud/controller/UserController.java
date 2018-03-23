package com.eroberer.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eroberer.crud.model.User;
import com.eroberer.crud.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
		return userRepository.findById(userId).get();
	}

	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {
		Optional<User> user = userRepository.findById(userId);

		if (user.isPresent()) {
			user.get().setName(userDetails.getName());
			user.get().setSurname(userDetails.getSurname());
			user.get().setBirthDate(userDetails.getBirthDate());
			return userRepository.save(user.get());
		}

		return null;
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
		Optional<User> user = userRepository.findById(userId);

		if (user.isPresent()) {
			userRepository.delete(user.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
