package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.dell.entities.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
