package com.zerasi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zerasi.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerasi.entity.Teacher;
import com.zerasi.entity.TeacherExample;
import com.zerasi.entity.User;
import com.zerasi.entity.UserComment;
import com.zerasi.entity.UserCommentExample;
import com.zerasi.entity.TeacherExample.Criteria;
import com.zerasi.service.TeacherService;
import com.zerasi.utils.PageResult;
import com.zerasi.utils.Result;



@RestController
@RequestMapping("teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService TeacherService;
	
	@RequestMapping("findAll")
	public List<Teacher> findALl(Teacher Teacher){
		TeacherExample example = new TeacherExample();
		Criteria criteria = example.createCriteria();
		if(Teacher.getId()!=null){
			criteria.andIdEqualTo(Teacher.getId());
		}
		return TeacherService.findAll(example);
	}
	
	@RequestMapping("add")
	public Result add(Teacher Teacher){
		try {
			Teacher.setPassword(Md5Utils.Encrypt(Teacher.getPassword()));
			if(Teacher.getId()==null){
				this.TeacherService.add(Teacher);
			}else{
				this.TeacherService.update(Teacher);
			}
			return new Result(true, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "失败");
		}
	}
	
	
	@RequestMapping("login")
	public Result login(HttpServletRequest request ,Teacher Teacher){
		try {
			TeacherExample example = new TeacherExample();
			example.createCriteria().andUsernameEqualTo(Teacher.getUsername()).andPasswordEqualTo(Md5Utils.Encrypt(Teacher.getPassword()));
			Teacher existTeacher = this.TeacherService.login(example);
			if(existTeacher==null){
				return new Result(false, "登录失败");
			}
			request.getSession().setAttribute("Teacher", existTeacher);
			return new Result(true, "登录成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "登录失败");
		}
	}
	
	@RequestMapping("logout")
	public Result logout(HttpServletRequest request){
		try {
			request.getSession().setAttribute("Teacher", null);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	
	@RequestMapping("zhanshi")
	public Teacher zhanshi(HttpServletRequest request){
		Map<String ,Object> map = new HashMap();
		Teacher Teacher = (Teacher) request.getSession().getAttribute("Teacher");
		return Teacher;
	}
	
	@RequestMapping("findPage")
	public PageResult findPage(Teacher Teacher,Integer page,Integer rows){
		TeacherExample example = new TeacherExample();
		
		return this.TeacherService.findPage(example,page,rows);
	}

	@RequestMapping("findPageMine")
	public PageResult findPageMine(Teacher Teacher,Integer page,Integer rows,HttpServletRequest request){
		TeacherExample example = new TeacherExample();
		Teacher teacherExist = (Teacher) request.getSession().getAttribute("Teacher");
		example.createCriteria().andIdEqualTo(teacherExist.getId());
		return this.TeacherService.findPage(example,page,rows);
	}

	@RequestMapping("findOne")
	public Teacher findOne(Integer id){
		Teacher Teacher = this.TeacherService.findOne(id);
		return Teacher;
	}
	
	@RequestMapping("update")
	public Result update( Teacher Teacher){
		try {
			Teacher.setPassword(Md5Utils.Encrypt(Teacher.getPassword()));
			this.TeacherService.update(Teacher);
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
				this.TeacherService.delete(Integer.parseInt(id));
			}
			return new Result(true, "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "操作失败");
		}
	} 
	@RequestMapping(value="findConmentByTeacher")
	public List<UserComment> findConmentByTeacher(UserComment comment){
		
		try {
			UserCommentExample example = new UserCommentExample();
			UserCommentExample.Criteria criteria = example.createCriteria();
			if(comment.getTch_id()!=null){
				criteria.andTch_idEqualTo(comment.getTch_id());
			}
			return this.TeacherService.findConmentByTeacher(example);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
	
	@RequestMapping(value="addComment")
	public Result addComment(HttpServletRequest request,UserComment comment){
		
		try {
			User user = (User) request.getSession().getAttribute("user");
			comment.setUid(user.getId());
			this.TeacherService.addComment(comment);
			return new Result(true, "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "操作失败");
		}
	} 
	
	@RequestMapping("search")
	public PageResult search( Teacher Teacher, Integer page, Integer rows){
		return this.findPage(Teacher,page, rows);
	}
}
