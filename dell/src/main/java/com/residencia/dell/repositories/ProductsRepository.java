package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.dell.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
