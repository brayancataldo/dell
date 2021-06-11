package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.OrderlinesId;

@Repository
public interface OrderlinesRepository extends JpaRepository<Orderlines, OrderlinesId>{

	//Orderlines findByOrderlineIdAndOrderId(Integer orderlineId, Integer orderId)
	
}
