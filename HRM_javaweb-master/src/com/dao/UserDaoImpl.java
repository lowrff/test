package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.util.DBconn;

public class UserDaoImpl implements UserDao {
	/* 分别实现对employee表操作和user表的操作 */
	/* register */
	public boolean register_user(User user) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("insert into user(name,pwd,info) " + "values('" + user.getName() + "','"
				+ user.getPwd() + "','" + user.getInfo() + "')");
		if (i > 0) {
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

	public boolean register_em(User employee) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel(
				"insert into employee(name,pwd,sex,position,salary,home,info) " + "values('" + employee.getName()
						+ "','" + employee.getPwd() + "','" + employee.getSex() + "','" + employee.getPosition() + "','"
						+ employee.getSalary() + "','" + employee.getHome() + "','" + employee.getInfo() + "')");
		if (i > 0) {
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

	public boolean login_user(String name, String pwd) {
		boolean flag = false;
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from user where name='" + name + "' and pwd='" + pwd + "'");
			while (rs.next()) {
				if (rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)) {
					flag = true;
				}
			}
			DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/* 获取user表全部内容 */
	/*
	 * public List<User> getUserAll() { List<User> list = new ArrayList<User>();
	 * try { DBconn.init(); ResultSet rs =
	 * DBconn.selectSql("select * from user"); while(rs.next()){ User user = new
	 * User(); user.setId(rs.getInt("id")); user.setName(rs.getString("name"));
	 * user.setPwd(rs.getString("pwd")); user.setSex(rs.getString("sex"));
	 * user.setHome(rs.getString("home")); user.setInfo(rs.getString("info"));
	 * list.add(user); } DBconn.closeConn(); return list; } catch (SQLException
	 * e) { e.printStackTrace(); } return null; }
	 */
	public List<User> getEmployeeAll() {
		List<User> list = new ArrayList<User>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from employee");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setSex(rs.getString("sex"));
				user.setPosition(rs.getString("position"));
				user.setSalary(rs.getDouble("salary"));
				user.setHome(rs.getString("home"));
				user.setInfo(rs.getString("info"));
				list.add(user);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean update_em(int id, String name, String pwd, String sex, String position, double salary, String home,
			String info) {
		boolean flag = false;
		DBconn.init();
		String sql = "update employee set name ='" + name + "' , pwd ='" + pwd + "' , sex ='" + sex + "' , position ='"
				+ position + "' ,salary ='" + salary + "' ,home ='" + home + "' , info ='" + info + "' where id = "
				+ id;
		int i = DBconn.addUpdDel(sql);
		if (i > 0) {
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

	public boolean delete_em(int id) {
		boolean flag = false;
		DBconn.init();
		String sql = "delete  from employee where id=" + id;
		int i = DBconn.addUpdDel(sql);
		if (i > 0) {
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

}
