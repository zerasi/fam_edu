package com.zerasi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zerasi.dao.CategoryMapper;
import com.zerasi.dao.CourseMapper;
import com.zerasi.dao.TeacherMapper;
import com.zerasi.dao.UserCourseMapper;
import com.zerasi.entity.Category;
import com.zerasi.entity.Course;
import com.zerasi.entity.CourseExample;
import com.zerasi.entity.User;
import com.zerasi.entity.UserCourse;
import com.zerasi.entity.UserCourseExample;
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
	public void addUserCourse(User user, Integer id) {
		UserCourse userCourse = new UserCourse();
		userCourse.setCour_id(id);
		userCourse.setUid(user.getId());
		this.ucMapper.insert(userCourse);
	}

	@Override
	public void deletechoose(Integer id) {
		this.ucMapper.deleteByPrimaryKey(id);
		
	}

}
