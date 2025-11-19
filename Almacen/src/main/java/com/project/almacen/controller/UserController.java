package com.project.almacen.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.almacen.cmmon.QueryPageParam;
import com.project.almacen.entity.User;
import com.project.almacen.service.UserService;
import com.project.almacen.cmmon.Result;

@RestController
public class UserController {

	@GetMapping("/hello")
	public String test() {

		return "new test";
	}

	@Autowired
	private UserService userService;

	@GetMapping("/userList")
	public List<User> list() {
		return userService.list();
	}

	// Insert
	@PostMapping("/save")
	public Result save(@RequestBody User user) {

		return userService.save(user)?Result.success():Result.fail();

	}

	// update
	@PostMapping("/update")
	public boolean update(@RequestBody User user) {

		return userService.updateById(user);
	}

	// delete
	@PostMapping("/delete")
	public boolean delete(Integer id) {

		return userService.removeById(id);
	}

	@GetMapping("/listP")
	public Result listP(@RequestParam(required = false) String name) {
	    LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
	    if(StringUtils.isNotBlank(name)) {
	        lambdaQueryWrapper.like(User::getName, name);
	    }
	    return Result.success(userService.list(lambdaQueryWrapper));
	}

	@PostMapping("/listPage")
	public Result listPage(@RequestBody QueryPageParam param) {
		

		HashMap queryParam = param.getParam();

		String name = (String) queryParam.get("name");
		String sex = (String) queryParam.get("sex");

		Page<User> page = new Page<User>();
		page.setCurrent(param.getPageNum());
		page.setSize(param.getPageSize());

		LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
		if(StringUtils.isNotBlank(name) && !"null".equals(name)) {
			lambdaQueryWrapper.like(User::getName, name);
		}
		
		if(StringUtils.isNotBlank(sex) ) {
			lambdaQueryWrapper.eq(User::getSex,  Integer.parseInt(sex));
		}
		
		

		IPage<User> resutlIPage = userService.page(page, lambdaQueryWrapper);
		return Result.success(resutlIPage.getRecords(), resutlIPage.getTotal());
	}

	@PostMapping("/listPageSex")
	public Result listPageSex(@RequestBody QueryPageParam param) {
		

		HashMap queryParam = param.getParam();

		//String name = (String) queryParam.get("name");
		String sex = (String) queryParam.get("sex");
		

		Page<User> page = new Page<User>();
		page.setCurrent(param.getPageNum());
		page.setSize(param.getPageSize());
		
		LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
		/*if(StringUtils.isNotBlank(name) && !"null".equals(name)) {
			lambdaQueryWrapper.like(User::getName, name);
		}*/
		if(StringUtils.isNotBlank(sex) ) {
			lambdaQueryWrapper.eq(User::getSex,  Integer.parseInt(sex));
		}
		
		IPage<User> resutlIPage = userService.page(page, lambdaQueryWrapper);
		
		return Result.success(resutlIPage.getRecords(), resutlIPage.getTotal());
	}

}
