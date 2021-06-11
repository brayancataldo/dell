package com.residencia.dell.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.dell.entities.Categories;
import com.residencia.dell.services.CategoriesService;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired 
	private CategoriesService categoriesService;
	
	@GetMapping
	public ResponseEntity<List<Categories>> findAll(Pageable page){
		   HttpHeaders header = new HttpHeaders();
	        return new ResponseEntity<>(categoriesService.findAll(page), header, HttpStatus.OK);
	}
}
