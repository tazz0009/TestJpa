package com.tazz009.jpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Product;
import com.tazz009.jpa.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository ProductRepository;

	public Product save(Product product) {
		return ProductRepository.save(product);
	}

	public Optional<Product> find(Product product) {
		return ProductRepository.findById(product.getId());
	}
	
}
