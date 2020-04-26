package com.zerasi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zerasi.dao.TeacherMapper;
import com.zerasi.dao.UserCommentMapper;
import com.zerasi.dao.UserMapper;
import com.zerasi.entity.Teacher;
import com.zerasi.entity.TeacherExample;
import com.zerasi.entity.UserComment;
import com.zerasi.entity.UserCommentExample;
import com.zerasi.service.TeacherService;
import com.zerasi.utils.PageResult;



@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherMapper TeacherMapper;

	@Autowired
	private UserCommentMapper commentMapper;

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void add(Teacher Teacher) {
		this.TeacherMapper.insertSelective(Teacher);
		
	}

	@Override
	public void update(Teacher Teacher) {
		this.TeacherMapper.updateByPrimaryKeySelective(Teacher);
		
	}

	@Override
	public Teacher login(TeacherExample example) {
		List<Teacher> list = this.TeacherMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public PageResult findPage(TeacherExample example, Integer page, Integer rows) {
		PageHelper.startPage(page,rows);
		Page<Teacher> pages = (Page<Teacher>)this.TeacherMapper.selectByExample(example);
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public Teacher findOne(Integer id) {
		return this.TeacherMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(int parseInt) {
		this.TeacherMapper.deleteByPrimaryKey(parseInt);
		
	}

	@Override
	public List<Teacher> findAll(TeacherExample example) {
		return this.TeacherMapper.selectByExample(example);
	}

	@Override
	public List<UserComment> findConmentByTeacher(UserCommentExample example) {
		List<UserComment> list = this.commentMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setTeacher(this.TeacherMapper.selectByPrimaryKey(list.get(i).getTch_id()));
			list.get(i).setUser(this.userMapper.selectByPrimaryKey(list.get(i).getUid()));
		}
		return list;
	}

	@Override
	public void addComment(UserComment comment) {
		this.commentMapper.insert(comment);
		
	}

}
