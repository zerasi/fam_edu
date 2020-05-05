package com.zerasi.service;

import java.util.List;

import com.zerasi.entity.*;
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

	void addUserCourse(UserCourse userCourse);

	void deletechoose(Integer id);

	PageResult teachLookChoose(Teacher teacher, Integer page, Integer rows);

    void userCourseStatus(UserCourse userCourse);
}
