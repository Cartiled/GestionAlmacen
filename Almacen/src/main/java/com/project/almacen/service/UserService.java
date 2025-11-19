package com.project.almacen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.project.almacen.entity.User;

public interface UserService extends IService<User> {

	IPage<User> pageC(IPage<User> page);

}
