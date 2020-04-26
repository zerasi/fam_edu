package com.zerasi.service;

import java.util.List;

import com.zerasi.entity.Course;
import com.zerasi.entity.CourseExample;
import com.zerasi.entity.User;
import com.zerasi.entity.UserCourse;
import com.zerasi.entity.UserCourseExample;
import com.zerasi.utils.PageResult;

public interface CourseService {

	List<Course> findAll(CourseExample example);

	void add(Course Course);

	void update(Course Course);

	Course login(CourseExample example);

	PageResult findPage(CourseExample example, Integer page, Integer rows);

	Course findOne(Integer id);

	void delete(int parseInt);

	List<UserCourse> findUserCourse(UserCourseExample example);

	void addUserCourse(User user, Integer id);

	void deletechoose(Integer id);

}
