package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.CustHist;
import com.residencia.dell.repositories.CustHistRepository;

@Service
public class CustHistService {

	@Autowired
	public CustHistRepository custHistRepository;
	
	public CustHist findById(Integer id) {
		return custHistRepository.findById(id).get();
	}
	
	public List<CustHist> findAll(){
		return custHistRepository.findAll();
	}
	
	public Long count() {
		return custHistRepository.count();
	}
	
	public CustHist save(CustHist custHist) {
		CustHist newCustHist = custHistRepository.save(custHist);
		return newCustHist;
	}
	
	public boolean delete(Integer id) {
		if (id!=null) {
			custHistRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
}

