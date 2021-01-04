package com.netset.bean;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "pid", nullable = false)
	private Product product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;

	}

	@Override
	public String toString() {
		return "Category{" + "id=" + id + ", name='" + name + '\'' + ", product=" + product + '}';
	}
}