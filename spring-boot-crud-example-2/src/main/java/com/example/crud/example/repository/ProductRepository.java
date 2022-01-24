package com.example.crud.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.crud.example.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {

	Product findByName(String name);

}
