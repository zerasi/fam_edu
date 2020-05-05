package com.zerasi.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zerasi.dao.*;
import com.zerasi.entity.*;
import com.zerasi.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zerasi.service.CourseService;
import com.zerasi.utils.PageResult;



@Service
@Transactional
public class CouseServiceImpl implements CourseService{
	
	@Autowired
	private CourseMapper CourseMapper;

	@Autowired
	private CategoryMapper cateMapper;
	
	@Autowired
	private TeacherMapper tmapper;

	@Autowired
	private UserCourseMapper ucMapper;

	@Autowired
	private UserMapper userMapper;

	@Override
	public void add(Course Course) {
		this.CourseMapper.insertSelective(Course);
		
	}

	@Override
	public void update(Course Course) {
		this.CourseMapper.updateByPrimaryKeySelective(Course);
		
	}

	@Override
	public Course login(CourseExample example) {
		return this.CourseMapper.selectByExample(example).get(0);
	}

	@Override
	public PageResult findPage(CourseExample example, Integer page, Integer rows) {
		PageHelper.startPage(page,rows);
		Page<Course> pages = (Page<Course>)this.CourseMapper.selectByExample(example);
		List<Course> list = pages.getResult();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setCategory(this.cateMapper.selectByPrimaryKey(list.get(i).getCate_id()));
			list.get(i).setTeacher(this.tmapper.selectByPrimaryKey(list.get(i).getTch_id()));
		}
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public Course findOne(Integer id) {
		Course c = this.CourseMapper.selectByPrimaryKey(id);
		c.setCategory(this.cateMapper.selectByPrimaryKey(c.getCate_id()));
		c.setTeacher(this.tmapper.selectByPrimaryKey(c.getTch_id()));;
		return c;
	}

	@Override
	public void delete(int parseInt) {
		this.CourseMapper.deleteByPrimaryKey(parseInt);
		
	}

	@Override
	public List<Course> findAll(CourseExample example) {
		List<Course> list = this.CourseMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setCategory(this.cateMapper.selectByPrimaryKey(list.get(i).getCate_id()));
			list.get(i).setTeacher(this.tmapper.selectByPrimaryKey(list.get(i).getTch_id()));
		}
		return list;
	}

	@Override
	public List<UserCourse> findUserCourse(UserCourseExample example) {
		List<UserCourse> list = this.ucMapper.selectByExample(example);
		for(int i = 0; i < list.size(); i++){
			Course course = this.CourseMapper.selectByPrimaryKey(list.get(i).getCour_id());
			course.setTeacher(this.tmapper.selectByPrimaryKey(course.getTch_id()));
			list.get(i).setCourse(course);
		}
		return list;
	}

	@Override
	public void addUserCourse(UserCourse userCourse) {
		Course course = this.CourseMapper.selectByPrimaryKey(userCourse.getCour_id());
		userCourse.setBak2((DateUtils.getHoursDateToDate(userCourse.getStart_date(),userCourse.getEnd_date()))*course.getPrice()+"");
		this.ucMapper.insert(userCourse);
	}

	@Override
	public void deletechoose(Integer id) {
		this.ucMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public PageResult teachLookChoose(Teacher teacher, Integer page, Integer rows) {

		CourseExample courseExample = new CourseExample();
		courseExample.createCriteria().andTch_idEqualTo(teacher.getId());
		List<Course> courses = this.CourseMapper.selectByExample(courseExample);
		List<Integer> courseInt = new ArrayList<>();
		for (Course course: courses){
			courseInt.add(course.getId());
		}

		UserCourseExample userCourseExample = new UserCourseExample();
		userCourseExample.createCriteria().andCour_idIn(courseInt);
		PageHelper.startPage(page,rows);
		Page<UserCourse> pages = (Page<UserCourse>)this.ucMapper.selectByExample(userCourseExample);
		List<UserCourse> list = pages.getResult();
		list.forEach(p ->{
			p.setUser(this.userMapper.selectByPrimaryKey(p.getUid()));
			p.setCourse(this.CourseMapper.selectByPrimaryKey(p.getCour_id()));
		});
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public void userCourseStatus(UserCourse userCourse) {
		this.ucMapper.updateByPrimaryKeySelective(userCourse);
	}

}
