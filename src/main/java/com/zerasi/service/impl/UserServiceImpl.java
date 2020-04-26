package com.zerasi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zerasi.dao.UserMapper;
import com.zerasi.entity.User;
import com.zerasi.entity.UserExample;
import com.zerasi.service.UserService;
import com.zerasi.utils.PageResult;



@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;



	@Override
	public void add(User user) {
		this.userMapper.insertSelective(user);
		
	}

	@Override
	public void update(User user) {
		this.userMapper.updateByPrimaryKeySelective(user);
		
	}

	@Override
	public User login(UserExample example) {
		List<User> list = this.userMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public PageResult findPage(UserExample example, Integer page, Integer rows) {
		PageHelper.startPage(page,rows);
		Page<User> pages = (Page<User>)this.userMapper.selectByExample(example);
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public User findOne(Integer id) {
		return this.userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(int parseInt) {
		this.userMapper.deleteByPrimaryKey(parseInt);
		
	}

	@Override
	public List<User> findAll(UserExample example) {
		return this.userMapper.selectByExample(example);
	}

}
