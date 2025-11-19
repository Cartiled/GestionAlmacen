package com.project.almacen.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.project.almacen.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

	IPage<User> pageC(IPage<User> page);
	
	
}
