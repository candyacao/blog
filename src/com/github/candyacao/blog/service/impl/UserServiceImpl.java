package com.github.candyacao.blog.service.impl;

import com.github.candyacao.blog.bean.User;
import com.github.candyacao.blog.dao.impl.UserDaoImpl;
import com.github.candyacao.blog.service.IUserService;

public class UserServiceImpl implements IUserService{

	@Override
	public boolean registerUser(User user) {
			//业务逻辑  注册用户
		//判断用户名是否被占用  需要借助于dao层
		//构建一个dao层实例
		UserDaoImpl daoImpl = new UserDaoImpl();
		//调用对应方法
		User user2 = daoImpl.selectUserByName(user.getName());
		if (user2 == null) {
			//该用户名没有被占用
			//直接注册
			daoImpl.saveUser(user);
			return true;
		}else {
			//该用户被占用
			//响应一个错误   error.html  register.html
			return false;
			
		}
	
	}

	@Override
	public String loginUser(String username, String password) {
		return null;
	}

	@Override
	public void updateUser(User user) {
				
	}

	@Override
	public void deleteUser(User user) {
		
	}

}
