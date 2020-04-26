package com.zerasi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zerasi.dao.CategoryMapper;
import com.zerasi.entity.Category;
import com.zerasi.entity.CategoryExample;
import com.zerasi.service.CategoryService;
import com.zerasi.utils.PageResult;



@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryMapper CategoryMapper;



	@Override
	public void add(Category Category) {
		this.CategoryMapper.insertSelective(Category);
		
	}

	@Override
	public void update(Category Category) {
		this.CategoryMapper.updateByPrimaryKeySelective(Category);
		
	}

	@Override
	public Category login(CategoryExample example) {
		return this.CategoryMapper.selectByExample(example).get(0);
	}

	@Override
	public PageResult findPage(CategoryExample example, Integer page, Integer rows) {
		PageHelper.startPage(page,rows);
		Page<Category> pages = (Page<Category>)this.CategoryMapper.selectByExample(example);
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public Category findOne(Integer id) {
		return this.CategoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(int parseInt) {
		this.CategoryMapper.deleteByPrimaryKey(parseInt);
		
	}

	@Override
	public List<Category> findAll(CategoryExample example) {
		return this.CategoryMapper.selectByExample(example);
	}

}
