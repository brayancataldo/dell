package com.residencia.dell.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Products;
import com.residencia.dell.repositories.ProductsRepository;
import com.residencia.dell.vo.ProductsVO;

@Service
public class ProductsService {

	@Autowired
	public ProductsRepository productsRepository;
	
	public Products findById(Integer id) {
		return productsRepository.findById(id).get();
	}
	
	// FIND BY ID VO
	public ProductsVO findByIdVO(Integer id) {
		ProductsVO productsVO = entidadeParaVO(productsRepository.findById(id).get());
		return productsVO;
		// a variavel productsVO recebe a entidade convertida, e usando também o método findById.
	}
	
	public List<Products> findAll(){
		return productsRepository.findAll();
	}
	
	// LISTA PRODUTOS VO
	public List<ProductsVO> findAllVO(){
		List<ProductsVO> listProductsVO = new ArrayList<>();
		List<Products> listProducts = new ArrayList<>();
		listProducts = productsRepository.findAll();
		// para cada Produto, na lista de produtos, guarde o produto ja convertido na listaProductsVO.
		for (Products products : listProducts) {
			listProductsVO.add(entidadeParaVO(products));
		}
		return listProductsVO;
	}
	
	public Long count() {
		return productsRepository.count();
	}
	
	public Products save(Products products) {
		Products newProduct = productsRepository.save(products);
		return newProduct;
	}
	
	public Products update(Products products, Integer id) {
		products.setProdId(id);
		return productsRepository.save(products);
	}
		
	public boolean delete(Integer id) {
		if(id!=null) {
			productsRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	// CONVERTEDOR DE ENTIDADE PARA VO
	public ProductsVO entidadeParaVO(Products products) {
		ProductsVO productsVO = new ProductsVO();
		productsVO.setProdId(products.getProdId());
		productsVO.setCategory(products.getCategory());
		productsVO.setTitle(products.getTitle());
		productsVO.setActor(products.getActor());
		productsVO.setPrice(products.getPrice());
		productsVO.setSpecial(products.getSpecial());
		return productsVO;
	}
}
