package com.residencia.dell.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orderlines")
public class Orderlines {

	@EmbeddedId
	OrderlinesId orderlinesId;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "orderid", referencedColumnName = "orderid", insertable = false, updatable = false)
	private Orders orders;
		
	@Column(name = "prod_id")
	private Integer prodId;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "orderdate")
	private Calendar orderDate;
	
	public Orderlines() {
	}
	
	public Orderlines(Integer orderlineid, Integer orderid, Integer prodId, Integer quantity,
			Calendar orderDate) {
		
		OrderlinesId orderLinesId = new OrderlinesId(orderlineid, orderid); 
		
		this.orderlinesId = orderLinesId;
		this.prodId = prodId;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}
	
	public OrderlinesId getOrderlineId() {
		return orderlinesId;
	}

	public void setOrderlineId(OrderlinesId orderlinesId) {
		this.orderlinesId = orderlinesId;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

}
