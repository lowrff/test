package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	/* 人力资源管理部门需要看到雇员的信息，不需要看到自己管理员账户的信息 */
	public boolean login_user(String name, String pwd);

	public boolean register_em(User employee);

	public boolean register_user(User user);

	public List<User> getEmployeeAll();

	public boolean delete_em(int id);

	public boolean update_em(int id, String name, String pwd, String sex, String position, double salary, String home,
			String info);
}
