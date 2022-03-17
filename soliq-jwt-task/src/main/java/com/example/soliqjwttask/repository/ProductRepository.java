package com.example.soliqjwttask.repository;

import com.example.soliqjwttask.entity.Product;
import com.example.soliqjwttask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
