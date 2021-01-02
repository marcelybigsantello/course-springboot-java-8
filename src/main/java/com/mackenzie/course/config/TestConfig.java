package com.mackenzie.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mackenzie.course.entities.User;
import com.mackenzie.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria", "maria@gmail.com", "55555555", "123456");
		User u2 = new User(null, "João", "joão.costa@gmail.com", "5454545", "abcdef");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
	
}
