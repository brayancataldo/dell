package com.residencia.dell.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.dell.services.ProductsService;
import com.residencia.dell.vo.ProductsVO;

@RestController
@RequestMapping("/product")
public class ProductsController {

	@Autowired
	public ProductsService productsService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductsVO> findById(@PathVariable Integer id){
		HttpHeaders header = new HttpHeaders();
		ProductsVO novoVO = productsService.findByIdVO(id);
		if(novoVO != null)
			return new ResponseEntity<>(novoVO, header, HttpStatus.OK);
		else
			return new ResponseEntity<>(novoVO, header, HttpStatus.BAD_REQUEST);
	}
	
	 @GetMapping("/products_list")
	    public ResponseEntity<List<ProductsVO>> findAll(){
	        HttpHeaders header = new HttpHeaders();
	        return new ResponseEntity<>(productsService.findAllVO(), header, HttpStatus.OK);
	}
	
	
}
	
