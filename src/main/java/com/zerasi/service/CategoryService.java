package com.zerasi.service;

import java.util.List;

import com.zerasi.entity.Category;
import com.zerasi.entity.CategoryExample;
import com.zerasi.utils.PageResult;

public interface CategoryService {

	List<Category> findAll(CategoryExample example);

	void add(Category Category);

	void update(Category Category);

	Category login(CategoryExample example);

	PageResult findPage(CategoryExample example, Integer page, Integer rows);

	Category findOne(Integer id);

	void delete(int parseInt);

}
