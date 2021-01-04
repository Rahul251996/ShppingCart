package com.netset.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netset.Reposotory.ProductRepository;
import com.netset.bean.Product;

@Service
public class ProductService {

	private final ProductRepository repo;

	@Autowired
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}

	public void save(Product product) {
		repo.save(product);

	}

	public List<Product> getProduct(String pName, String color, String category) {

		if (pName != null) {
			// find by product name
			return repo.findAllByName(pName);
		} else if (color != null) {
			return repo.findAllByColor(color);
		} else if (category != null) {
			return repo.findAllByCategories_name(category);
		} else {
			return new ArrayList<>();
		}
	}

}