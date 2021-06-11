package com.residencia.dell.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Customers;
import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.CustomersRepository;
import com.residencia.dell.repositories.OrderlinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import com.residencia.dell.repositories.ProductsRepository;
import com.residencia.dell.vo.ItemOrderlinesVO;
import com.residencia.dell.vo.NotaFiscalVO;
import com.residencia.dell.vo.OrderlinesVO;
import com.residencia.dell.vo.OrdersVO;

@Service
public class OrdersService {

	@Autowired
	public OrdersRepository ordersRepository;
	
	@Autowired
	public OrderlinesRepository orderlinesRepository;
	
	@Autowired
	public ProductsRepository productsRepository;
	
	@Autowired
	public CustomersRepository customersRepository;

	//@Autowired
	//public EmailService emailService;
	
	public Orders saveVO(OrdersVO ordersVO) {

		Orders orders =  new Orders();
        Customers customer = customersRepository.findById(ordersVO.getCustomerId()).get();

        orders.setNetamount(ordersVO.getNetAmount());
        orders.setOrderDate(ordersVO.getOrderDate());
        orders.setOrderId(ordersVO.getOrderId());
        orders.setTax(ordersVO.getTax());
        orders.setTotalAmount(ordersVO.getTotalAmount());
        orders.setCustomerId(customer);
        
        Orders newOrders = ordersRepository.save(orders);

        Integer contadorOrderlinesId = 1;
        
        List<Orderlines> listNewOrderlines = new ArrayList<>();
        for (OrderlinesVO itemOrderlinesVO : ordersVO.getListOrderlinesVO()) {
            Orderlines orderlines = new Orderlines(
            		contadorOrderlinesId, 
            		newOrders.getOrderId(),
            		itemOrderlinesVO.getProdId(),
            		itemOrderlinesVO.getQuantity(),
            		itemOrderlinesVO.getOrderDate()
            		);
            
            Orderlines newOrderlines = orderlinesRepository.save(orderlines);
            
            listNewOrderlines.add(newOrderlines);
            
            contadorOrderlinesId++;
        }
        
        newOrders.setListOrderlines(listNewOrderlines);

        return newOrders;

    }
	
	
	
	public Orders findById(Integer id) {
		return ordersRepository.findById(id).get();
	}
	
	// FIND BY ID VO
	public OrdersVO findByIdVO(Integer id) {
		OrdersVO ordersVO = entidadeParaVO(ordersRepository.findById(id).get());
		return ordersVO;
	}
	
	/*
	public List<Orders> findAll() {
		return ordersRepository.findAll();
	}
	*/
	
	
	// LISTA ORDERS VO
	public List<OrdersVO> findAllVO(){
		List<OrdersVO> listOrdersVO = new ArrayList<>();
		List<Orders> listOrders = new ArrayList<>();
		listOrders = ordersRepository.findAll();
		for (Orders orders : listOrders) {
			listOrdersVO.add(entidadeParaVO(orders));
		}
		return listOrdersVO;
	}
	
	public Long count() {
		return ordersRepository.count();
	}
	
	public Orders save(Orders orders) {
		Orders newOrders = ordersRepository.save(orders);
		return newOrders;
	}
	
	public Orders update(Orders orders, Integer id) {
		orders.setOrderId(id);
		return ordersRepository.save(orders);
	}
	
	public boolean delete(Integer id) {
		if(id!=null) {
			ordersRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}	
	
	public OrdersVO entidadeParaVO(Orders orders) {
		OrdersVO ordersVO = new OrdersVO();
		ordersVO.setOrderId(orders.getOrderId());
		ordersVO.setOrderDate(orders.getOrderDate());
		ordersVO.setNetAmount(orders.getNetamount());
		ordersVO.setTax(orders.getTax());
		ordersVO.setTotalAmount(orders.getTotalAmount());
		return ordersVO;
	}
	
	public NotaFiscalVO emitirNF(Integer orderId) {
		
		Orders orders = ordersRepository.getById(orderId);
		
		List<Orderlines> listOrderlines = orders.getListOrderlines();
				
		NotaFiscalVO notaFiscalVO = new NotaFiscalVO();
		
		notaFiscalVO.setCustomerFirstName(orders.getCustomerId().getFirstName());
		notaFiscalVO.setCustomerLastName(orders.getCustomerId().getLastName());
		notaFiscalVO.setNetAmount(orders.getNetamount());
		notaFiscalVO.setOrderDate(orders.getOrderDate());
		notaFiscalVO.setOrderId(orders.getOrderId());
		notaFiscalVO.setTotalAmount(orders.getTotalAmount());

		List<ItemOrderlinesVO> listItemOrderlinesVO = new ArrayList<>();
		
		for(Orderlines orderlines : listOrderlines) {
			
			ItemOrderlinesVO itemOrderlinesVO = new ItemOrderlinesVO();
			
			itemOrderlinesVO.setProdId(orderlines.getProdId());
			itemOrderlinesVO.setQuantity(orderlines.getQuantity());
			itemOrderlinesVO.setTitle(productsRepository.findById(orderlines.getProdId()).get().getTitle());
			itemOrderlinesVO.setPrice(productsRepository.findById(orderlines.getProdId()).get().getPrice());
			
			listItemOrderlinesVO.add(itemOrderlinesVO);
		}

		notaFiscalVO.setListItemOrderlinesVO(listItemOrderlinesVO);;		
		
		return notaFiscalVO;
		}

	/*
    private Orders convertVOParaEntidade(OrdersVO ordersVO) {
        Orders orders = new Orders();

        Customers customer = customersRepository.getById(ordersVO.getCustomerId());

        orders.setNetamount(ordersVO.getNetAmount());
        orders.setOrderDate(ordersVO.getOrderDate());
        orders.setOrderId(ordersVO.getOrderId());
        orders.setTax(ordersVO.getTax());
        orders.setTotalAmount(ordersVO.getTotalAmount());
        orders.setCustomerId(customer);

        List<Orderlines> listOrderlines = new ArrayList<>();
        for (OrderlinesVO itemOrderlinesVO : ordersVO.getListOrderlinesVO()) {
            Orderlines orderlines = new Orderlines();

            orderlines.setOrderDate(itemOrderlinesVO.getOrderDate());
            orderlines.setOrderlineId(itemOrderlinesVO.getOrderlineId());
            orderlines.setProdId(itemOrderlinesVO.getProdId());
            orderlines.setQuantity(itemOrderlinesVO.getQuantity());

            listOrderlines.add(orderlines);
        }

        orders.setListOrderlines(listOrderlines);

        return orders;
    }
	*/
}
