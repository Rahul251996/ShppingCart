package com.netset.Reposotory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netset.bean.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findAllByName(String pname);

	List<Product> findAllByColor(String color);

	List<Product> findAllByCategories_name(String cat);

}