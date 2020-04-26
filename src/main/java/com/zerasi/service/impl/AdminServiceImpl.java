package com.zerasi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zerasi.dao.AdminMapper;
import com.zerasi.entity.Admin;
import com.zerasi.entity.AdminExample;
import com.zerasi.service.AdminService;
import com.zerasi.utils.PageResult;



@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper AdminMapper;



	@Override
	public void add(Admin Admin) {
		this.AdminMapper.insertSelective(Admin);
		
	}

	@Override
	public void update(Admin Admin) {
		this.AdminMapper.updateByPrimaryKeySelective(Admin);
		
	}

	@Override
	public Admin login(AdminExample example) {
		List<Admin> list = this.AdminMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public PageResult findPage(AdminExample example, Integer page, Integer rows) {
		PageHelper.startPage(page,rows);
		Page<Admin> pages = (Page<Admin>)this.AdminMapper.selectByExample(example);
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public Admin findOne(Integer id) {
		return this.AdminMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(int parseInt) {
		this.AdminMapper.deleteByPrimaryKey(parseInt);
		
	}

	@Override
	public List<Admin> findAll(AdminExample example) {
		return this.AdminMapper.selectByExample(example);
	}

}
