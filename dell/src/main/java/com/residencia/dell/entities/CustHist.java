package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cust_hist")
public class CustHist {
	
	@Id
	@Column(name = "customerid")
	private Integer customerId;
	
	@Column(name = "orderid")
	private Integer orderId;
	
	@ManyToOne
	@JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
	private Products prodId;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Products getProdId() {
		return prodId;
	}

	public void setProdId(Products prodId) {
		this.prodId = prodId;
	}

	
}
