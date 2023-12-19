package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.test.domain.User;
import com.example.test.repository.UserRepository;

@DataJpaTest
class UserTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	void saveAndRetrieveUser() {
		// Given
		User user = new User();
		user.setUsername("john_doe");
		user.setEmail("john.doe@example.com");

		// When
		userRepository.save(user);
		User retrievedUser = userRepository.findById(user.getId()).orElse(null);

		// Then
		assertNotNull(retrievedUser);
		assertEquals("john_doe", retrievedUser.getUsername());
		assertEquals("john.doe@example.com", retrievedUser.getEmail());
	}
}

