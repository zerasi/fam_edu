package com.zerasi.service;

import java.util.List;

import com.zerasi.entity.Teacher;
import com.zerasi.entity.TeacherExample;
import com.zerasi.entity.UserComment;
import com.zerasi.entity.UserCommentExample;
import com.zerasi.utils.PageResult;

public interface TeacherService {

	List<Teacher> findAll(TeacherExample example);

	void add(Teacher Teacher);

	void update(Teacher Teacher);

	Teacher login(TeacherExample example);

	PageResult findPage(TeacherExample example, Integer page, Integer rows);

	Teacher findOne(Integer id);

	void delete(int parseInt);

	List<UserComment> findConmentByTeacher(UserCommentExample example);

	void addComment(UserComment comment);

}
