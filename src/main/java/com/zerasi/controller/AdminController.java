package com.zerasi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zerasi.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerasi.entity.Admin;
import com.zerasi.entity.AdminExample;
import com.zerasi.service.AdminService;
import com.zerasi.utils.PageResult;
import com.zerasi.utils.Result;
import com.zerasi.utils.Ztree;
import sun.security.provider.MD5;


@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminService AdminService;
	
	@RequestMapping("ztree")
	public List<Ztree> ztree(){
		List<Ztree> z = new ArrayList<>();
		z.add(new Ztree(12, 0, "课程分类", null));
		z.add(new Ztree(119, 12, "课程分类", "pages/base/category"));
		z.add(new Ztree(119, 12, "课程管理", "pages/base/course"));
		z.add(new Ztree(13, 0, "人员管理", null));
		z.add(new Ztree(119, 13, "管理员", "pages/base/admin"));
		z.add(new Ztree(119, 13, "教师管理", "pages/base/teacher"));
		z.add(new Ztree(119, 13, "用户管理", "pages/base/user"));
		return z;
	}
	
	@RequestMapping("findAll")
	public List<Admin> findALl(Admin Admin){
		AdminExample example = new AdminExample();
		return AdminService.findAll(example);
	}
	
	@RequestMapping("add")
	public Result add(Admin Admin){
		try {
			Admin.setPassword(Md5Utils.Encrypt(Admin.getPassword()));
			if(Admin.getId()==null){
				this.AdminService.add(Admin);
			}else{
				this.AdminService.update(Admin);
			}
			return new Result(true, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "失败");
		}
	}
	
	
	@RequestMapping("login")
	public Result login(HttpServletRequest request ,Admin Admin){
		try {
			AdminExample example = new AdminExample();
			example.createCriteria().andUsernameEqualTo(Admin.getUsername()).andPasswordEqualTo(Md5Utils.Encrypt(Admin.getPassword()));
			Admin existAdmin = this.AdminService.login(example);
			request.getSession().setAttribute("Admin", existAdmin);
			if(existAdmin==null){
				return new Result(false, "添加失败");
			}
			return new Result(true, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	@RequestMapping("logout")
	public Result logout(HttpServletRequest request){
		try {
			request.getSession().setAttribute("Admin", null);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	
	@RequestMapping("zhanshi")
	public Admin zhanshi(HttpServletRequest request){
		Map<String ,Object> map = new HashMap();
		Admin Admin = (Admin) request.getSession().getAttribute("Admin");
		return Admin;
	}
	
	@RequestMapping("findPage")
	public PageResult findPage(Admin Admin,Integer page,Integer rows){
		AdminExample example = new AdminExample();
		
		return this.AdminService.findPage(example,page,rows);
	}
	
	@RequestMapping("findOne")
	public Admin findOne(Integer id){
		Admin Admin = this.AdminService.findOne(id);
		return Admin;
	}
	
	@RequestMapping("update")
	public Result update( Admin Admin){
		try {
			Admin.setPassword(Md5Utils.Encrypt(Admin.getPassword()));
			this.AdminService.update(Admin);
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
				this.AdminService.delete(Integer.parseInt(id));
			}
			return new Result(true, "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "操作失败");
		}
	} 
	
	@RequestMapping("search")
	public PageResult search( Admin Admin, Integer page, Integer rows){
		return this.findPage(Admin,page, rows);
	}
}
