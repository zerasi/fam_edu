package com.zerasi.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerasi.entity.Course;
import com.zerasi.entity.CourseExample;
import com.zerasi.entity.User;
import com.zerasi.entity.UserCourse;
import com.zerasi.entity.UserCourseExample;
import com.zerasi.entity.CourseExample.Criteria;
import com.zerasi.service.CourseService;
import com.zerasi.utils.PageResult;
import com.zerasi.utils.Result;



@RestController
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseService CourseService;
	
	@RequestMapping("findAll")
	public List<Course> findALl(Course Course){
		CourseExample example = new CourseExample();
		Criteria createCriteria = example.createCriteria();
		if(Course.getCate_id()!=null){
			createCriteria.andCate_idEqualTo(Course.getCate_id());
		}
		if(Course.getName()!=null){
			createCriteria.andNameLike("%"+Course.getName()+"%");
		}
		if(Course.getTch_id()!=null){
			createCriteria.andTch_idEqualTo(Course.getTch_id());
		}
		return CourseService.findAll(example);
	}
	
	@RequestMapping("add")
	public Result add(Course Course){
		try {
			if(Course.getId()==null){
				this.CourseService.add(Course);
			}else{
				this.CourseService.update(Course);
			}
			return new Result(true, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "失败");
		}
	}
	
	
	
	
	@RequestMapping("logout")
	public Result logout(HttpServletRequest request){
		try {
			request.getSession().setAttribute("Course", null);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	
	@RequestMapping("xuanke")
	public Result xuanke(HttpServletRequest request,Integer id){
		User user = (User) request.getSession().getAttribute("user");
		UserCourseExample example = new UserCourseExample();
		example.createCriteria().andUidEqualTo(user.getId()).andCour_idEqualTo(id);
		List<UserCourse> list = this.CourseService.findUserCourse(example);
		if(list.size()>0){
			return new Result(false, "该课程选过了");
		}
		try {
			this.CourseService.addUserCourse(user,id);
			return new Result(true, "选课成功");
		} catch (Exception e) {
			return new Result(true, "选课失败");
		}
	}
	
	@RequestMapping("usercourse")
	public List<UserCourse> usercourse(HttpServletRequest request,Integer id){
		User user = (User) request.getSession().getAttribute("user");
		UserCourseExample example = new UserCourseExample();
		example.createCriteria().andUidEqualTo(user.getId());
		List<UserCourse> list = this.CourseService.findUserCourse(example);
		if(list.size()>0){
			return list;
		}
		return null;
	}
	@RequestMapping("commentTeacher")
	public Result commentTeacher(HttpServletRequest request,Integer tch_id){
		User user = (User) request.getSession().getAttribute("user");
		UserCourseExample example = new UserCourseExample();
		example.createCriteria().andUidEqualTo(user.getId());
		List<UserCourse> list = this.CourseService.findUserCourse(example);
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			Course course = this.CourseService.findOne(list.get(i).getCour_id());
			if(course.getTeacher().getId() == tch_id){
				flag = true;
			}
		}
		if(flag){
			return new Result(true, "修改成功");
		}
		return new Result(false, "修改失败");
	}
	
	@RequestMapping("findPage")
	public PageResult findPage(Course Course,Integer page,Integer rows){
		CourseExample example = new CourseExample();
		Criteria createCriteria = example.createCriteria();
		if(Course.getCate_id()!=null){
			createCriteria.andCate_idEqualTo(Course.getCate_id());
		}
		if(Course.getName()!=null){
			createCriteria.andNameLike("%"+Course.getName()+"%");
		}
		if(Course.getTch_id()!=null){
			createCriteria.andTch_idEqualTo(Course.getTch_id());
		}
		return this.CourseService.findPage(example,page,rows);
	}
	
	@RequestMapping("findOne")
	public Course findOne(Integer id){
		Course Course = this.CourseService.findOne(id);
		return Course;
	}
	
	@RequestMapping("update")
	public Result update( Course Course){
		try {
			this.CourseService.update(Course);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}
	
	@RequestMapping(value="delete")
	public Result delete(String ids){
		
		try {
			for (String id : ids.split(",")) {
				this.CourseService.delete(Integer.parseInt(id));
			}
			return new Result(true, "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "操作失败");
		}
	} 
	@RequestMapping(value="deletechoose")
	public Result deletechoose(Integer id){
		
		try {
			this.CourseService.deletechoose(id);
			return new Result(true, "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "操作失败");
		}
	} 
	
	@RequestMapping("search")
	public PageResult search( Course Course, Integer page, Integer rows){
		return this.findPage(Course,page, rows);
	}
}
