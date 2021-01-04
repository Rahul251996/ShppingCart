package com.netset.Reposotory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netset.bean.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}