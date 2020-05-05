package com.zerasi.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zerasi.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zerasi.entity.User;
import com.zerasi.entity.UserExample;
import com.zerasi.service.UserService;
import com.zerasi.utils.PageResult;
import com.zerasi.utils.Result;
import sun.security.provider.MD5;


@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("index")
	@ResponseBody
	public String index(){
		return "index";
	}
	
	
	@RequestMapping("findAll")
	public List<User> findALl(User user){
		UserExample example = new UserExample();
		return userService.findAll(example);
	}
	
	@RequestMapping("add")
	public Result add(User User){
		try {
			if(User.getId()==null){
				User.setPassword(Md5Utils.Encrypt(User.getPassword()));
				this.userService.add(User);
			}else{
				User.setPassword(Md5Utils.Encrypt(User.getPassword()));
				this.userService.update(User);
			}
			return new Result(true, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "失败");
		}
	}
	
	
	@RequestMapping("login")
	public Result login(HttpServletRequest request ,User User){
		try {
			UserExample example = new UserExample();
			example.createCriteria().andUsernameEqualTo(User.getUsername()).andPasswordEqualTo(Md5Utils.Encrypt(User.getPassword()));
			User existUser = this.userService.login(example);
			if(existUser!=null){
				request.getSession().setAttribute("user", existUser);
				return new Result(true, "添加成功");
			}
			return new Result(false, "添加失败");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	@RequestMapping("logout")
	public Result logout(HttpServletRequest request){
		try {
			request.getSession().setAttribute("user", null);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	
	@RequestMapping("zhanshi")
	public Result zhanshi(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null){
			
			return new Result(true, user.getUsername());
		}
		return new Result(false, "");
	}
	
	@RequestMapping("findPage")
	public PageResult findPage(User User,Integer page,Integer rows){
		UserExample example = new UserExample();
		return this.userService.findPage(example,page,rows);
	}
	
	@RequestMapping("findOne")
	public User findOne(Integer id){
		User User = this.userService.findOne(id);
		return User;
	}
	
	@RequestMapping("update")
	public Result update( User User){
		try {
			User.setPassword(Md5Utils.Encrypt(User.getPassword()));
			this.userService.update(User);
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
				this.userService.delete(Integer.parseInt(id));
			}
			return new Result(true, "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "操作失败");
		}
	} 
	
	@RequestMapping("search")
	public PageResult search( User User, Integer page, Integer rows){
		return this.findPage(User,page, rows);
	}
}
