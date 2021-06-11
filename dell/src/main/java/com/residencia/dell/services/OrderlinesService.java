package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.OrderlinesId;
import com.residencia.dell.repositories.OrderlinesRepository;

@Service
public class OrderlinesService {

	@Autowired
	public OrderlinesRepository orderlinesRepository;
	
	public Orderlines findById(OrderlinesId id) {
		return orderlinesRepository.findById(id).get();
	}
	
	public List<Orderlines> findAll(){
		return orderlinesRepository.findAll();
	}

	public Long count() {
		return orderlinesRepository.count();
	}
	
	public Orderlines save(Orderlines orderlines) {
		Orderlines newOrderline = orderlinesRepository.save(orderlines);
		return newOrderline;
	}
	
	public Orderlines update(Orderlines orderlines, OrderlinesId id) {
		orderlines.setOrderlineId(id);
		return orderlinesRepository.save(orderlines);
	}
	
	public boolean delete(OrderlinesId id) {
		if (id!=null) {
			orderlinesRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
}
