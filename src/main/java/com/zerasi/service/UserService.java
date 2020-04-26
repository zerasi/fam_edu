package com.zerasi.service;

import java.util.List;

import com.zerasi.entity.User;
import com.zerasi.entity.UserExample;
import com.zerasi.utils.PageResult;

public interface UserService {

	List<User> findAll(UserExample example);

	void add(User user);

	void update(User user);

	User login(UserExample example);

	PageResult findPage(UserExample example, Integer page, Integer rows);

	User findOne(Integer id);

	void delete(int parseInt);

}
