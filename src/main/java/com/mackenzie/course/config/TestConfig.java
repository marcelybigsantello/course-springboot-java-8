package com.mackenzie.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mackenzie.course.entities.Category;
import com.mackenzie.course.entities.Order;
import com.mackenzie.course.entities.OrderItem;
import com.mackenzie.course.entities.Product;
import com.mackenzie.course.entities.User;
import com.mackenzie.course.entities.enums.OrderStatus;
import com.mackenzie.course.repositories.CategoryRepository;
import com.mackenzie.course.repositories.OrderItemRepository;
import com.mackenzie.course.repositories.OrderRepository;
import com.mackenzie.course.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria", "maria@gmail.com", "55555555", "123456");
		User u2 = new User(null, "João", "joão.costa@gmail.com", "5454545", "abcdef");
		User u3 = new User(null, "Marcely Biguzzi Santello", "marcely@hotmail.com.br", "123123123", "000000");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);
		Order o4 = new Order(null, Instant.parse("2019-01-20T00:30:22Z"), OrderStatus.SHIPPED, u2);
		Order o5 = new Order(null, Instant.parse("2020-05-20T12:10:57Z"), OrderStatus.DELIVERED, u3);
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Clothes and fashion");
		Category c4 = new Category(null, "Pets");
		Category c5 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "Laptop dell", "Laptop black 15HD 256 GB", 3756.00f, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0f, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0f, "");
		Product p4 = new Product(null, "Uma longa jornada", "Uma longa jornada. Autor: Nicholas Sparks. Editora: Arqueiro", 35.0f, "");
		Product p5 = new Product(null, "Ração premium", "Ração premium sabor churrasco para cachorros até 10kg", 60.99f, "");
		Product p6 = new Product(null, "Ração premium", "Ração premium sabor churrasco para cachorros acima de 10kg", 78.99f, "");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5));
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		p1.getCategories().add(c1);
		p1.getCategories().add(c5);
		p2.getCategories().add(c1);
		p3.getCategories().add(c1);
		p3.getCategories().add(c5);
		p4.getCategories().add(c2);
		p5.getCategories().add(c4);
		p6.getCategories().add(c4);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 1, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		OrderItem oi5 = new OrderItem(o4, p4, 3, p4.getPrice());
		OrderItem oi6 = new OrderItem(o5, p2, 1, p2.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5, oi6));
	}	
	
}
