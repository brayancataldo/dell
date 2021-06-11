package com.residencia.dell.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.dell.entities.Orders;
import com.residencia.dell.services.OrdersService;
import com.residencia.dell.vo.NotaFiscalVO;
import com.residencia.dell.vo.OrdersVO;


@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdersVO> findById(@PathVariable Integer id){
		HttpHeaders headers = new HttpHeaders();
		OrdersVO novoVO = ordersService.findByIdVO(id);
		if(novoVO != null)
			return new ResponseEntity<>(novoVO, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(novoVO, headers, HttpStatus.BAD_REQUEST);
	}
	
	 @GetMapping
	    public ResponseEntity<List<OrdersVO>> findAll(){
	        HttpHeaders header = new HttpHeaders();
	        return new ResponseEntity<>(ordersService.findAllVO(), header, HttpStatus.OK);
	}
	 
	 
	 @GetMapping("/nota-fiscal{id}")
	 public NotaFiscalVO emitirNotaF(@PathVariable Integer id){
		 NotaFiscalVO notaFiscal = ordersService.emitirNF(id);
		 return notaFiscal;
	 }
	 
	 @PostMapping
	    public ResponseEntity<Orders> saveVO(@Valid @RequestBody OrdersVO ordersVO) {
	        HttpHeaders headers = new HttpHeaders();
	        Orders newOrder = ordersService.saveVO(ordersVO);
	        if (null != newOrder)
	            return new ResponseEntity<>(newOrder, headers, HttpStatus.OK);
	        else
	            return new ResponseEntity<>(newOrder, headers, HttpStatus.BAD_REQUEST);
	    }
	 	
}
