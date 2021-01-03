package com.mackenzie.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mackenzie.course.entities.Category;
import com.mackenzie.course.entities.Order;
import com.mackenzie.course.entities.User;
import com.mackenzie.course.entities.enums.OrderStatus;
import com.mackenzie.course.repositories.CategoryRepository;
import com.mackenzie.course.repositories.OrderRepository;
import com.mackenzie.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria", "maria@gmail.com", "55555555", "123456");
		User u2 = new User(null, "João", "joão.costa@gmail.com", "5454545", "abcdef");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);
		Order o4 = new Order(null, Instant.parse("2019-01-20T00:30:22Z"), OrderStatus.SHIPPED, u2);
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Clothes and fashion");
		Category c4 = new Category(null, "Pets");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
	}	
	
}
