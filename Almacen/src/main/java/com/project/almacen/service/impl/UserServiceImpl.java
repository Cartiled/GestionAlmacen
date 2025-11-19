package com.project.almacen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.almacen.entity.User;
import com.project.almacen.mapper.UserMapper;
import com.project.almacen.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public IPage<User> pageC(IPage<User> page) {
		return userMapper.pageC(page);
	}

}
