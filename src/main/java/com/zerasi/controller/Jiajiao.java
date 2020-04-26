package com.zerasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zerasi.entity.Course;
import com.zerasi.entity.Teacher;
import com.zerasi.service.TeacherService;

@Controller
public class Jiajiao {
	
	@Autowired
	private TeacherService TeacherService;
	@Autowired
	private com.zerasi.service.CourseService CourseService;
	
	@RequestMapping("/jiajiao")
	public String index(){
		return "/teacherlist";
	}
	@RequestMapping("courselist")
	public String courselist(){
		return "courselist";
	}
	@RequestMapping("teacherlist")
	public String teacherlist(){
		return "teacherlist";
	}
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	@RequestMapping("register")
	public String register(){
		return "register";
	}
	@RequestMapping("articlelist")
	public String articlelist(){
		return "articlelist";
	}
	@RequestMapping("exam_index")
	public String exam_index(){
		return "exam_index";
	}
	@RequestMapping("askarea")
	public String askarea(){
		return "askarea";
	}
	@RequestMapping("coursecont")
	public String coursecont(){
		return "coursecont";
	}
	@RequestMapping("admin")
	public String admin(){
		return "admin/index";
	}
	@RequestMapping("adminLogin")
	public String adminLogin(){
		return "admin/login";
	}
	@RequestMapping("teacher")
	public String teacher2(Integer id,Model model){
		Teacher teacher = this.TeacherService.findOne(id);
		model.addAttribute("teacher", teacher);
		return "teacher";
	}
	@RequestMapping("course")
	public String course2(Integer id,Model model){
		Course course = this.CourseService.findOne(id);
		model.addAttribute("course", course);
		return "coursecont";
	}
	@RequestMapping("pages/base/category")
	public String category(){
		return "admin/pages/base/category";
	}
	@RequestMapping("pages/base/course")
	public String course(){
		return "admin/pages/base/course";
	}
	@RequestMapping("pages/base/teacher")
	public String teacher(){
		return "admin/pages/base/teacher";
	}
	@RequestMapping("pages/base/user")
	public String user(){
		return "admin/pages/base/user";
	}
	@RequestMapping("pages/base/admin")
	public String admin2(){
		return "admin/pages/base/admin";
	}
	@RequestMapping("home")
	public String home(){
		return "admin/home";
	}

}
