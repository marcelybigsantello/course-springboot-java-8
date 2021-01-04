package com.mackenzie.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mackenzie.course.entities.Product;

//Annotation opcional, mas irei incluir para fins didáticos
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
