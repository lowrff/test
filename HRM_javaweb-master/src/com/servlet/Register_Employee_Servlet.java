package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

public class Register_Employee_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String position = request.getParameter("position");
		String salary_str = request.getParameter("salary");
		double salary = Double.valueOf(salary_str.toString());//将参数转化为double数salary
		String home = request.getParameter("home");
		String info = request.getParameter("info");

		User employee = new User();
		employee.setName(name);
		employee.setPwd(pwd);
		employee.setSex(sex);
		employee.setPosition(position);
		employee.setSalary(salary);
		employee.setHome(home);
		employee.setInfo(info);

		UserDao ud = new UserDaoImpl();

		if (ud.register_em(employee)) {
			request.setAttribute("username", name);
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		} else {
			response.sendRedirect("fail.jsp");
		}
	}
}
