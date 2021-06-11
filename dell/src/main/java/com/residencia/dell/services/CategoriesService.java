package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Categories;
import com.residencia.dell.repositories.CategoriesRepository;

@Service
public class CategoriesService {

	@Autowired
	public CategoriesRepository categoriesRepository;
	
	public List<Categories> findAll(Pageable page){
		return categoriesRepository.findAll(page).getContent();
	}
	
}
