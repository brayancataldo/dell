package com.residencia.dell.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private Integer orderId;
	
	@Column(name = "orderdate")
	private Calendar orderDate;
	
	@ManyToOne
	@JoinColumn(name = "customerid", referencedColumnName="customerid")
	private Customers customerId;
	
	@Column(name = "netamount")
	private BigDecimal netamount;

	//@JsonBackReference
	@DecimalMax(value="100.0", inclusive = false, message = "Tax só pode conter 2 dígitos")
	@Digits(integer = 2, fraction = 2, message = "Tax só pode conter 2 dígitos")
	@Column(name = "tax")
	private BigDecimal tax;
	
	@Column(name = "totalamount")
	private BigDecimal totalAmount;

	@OneToMany (mappedBy = "orders")
	//@JsonManagedReference
	private List <Orderlines> listOrderlines;
		
	public List<Orderlines> getListOrderlines() {
		return listOrderlines;
	}

	public void setListOrderlines(List<Orderlines> listOrderlines) {
		this.listOrderlines = listOrderlines;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public Customers getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customers customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getNetamount() {
		return netamount;
	}

	public void setNetamount(BigDecimal netamount) {
		this.netamount = netamount;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
}
