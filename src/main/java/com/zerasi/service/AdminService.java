package com.zerasi.service;

import java.util.List;

import com.zerasi.entity.Admin;
import com.zerasi.entity.AdminExample;
import com.zerasi.utils.PageResult;

public interface AdminService {

	List<Admin> findAll(AdminExample example);

	void add(Admin Admin);

	void update(Admin Admin);

	Admin login(AdminExample example);

	PageResult findPage(AdminExample example, Integer page, Integer rows);

	Admin findOne(Integer id);

	void delete(int parseInt);

}
