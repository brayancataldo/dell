package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category")
	private Integer category;
	
	@Column(name= "categoryname")
	private String categoryname;

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
}
