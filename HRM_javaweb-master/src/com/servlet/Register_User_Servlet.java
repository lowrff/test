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

public class Register_User_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String info = request.getParameter("info");

		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setInfo(info);

		UserDao ud = new UserDaoImpl();

		if (ud.register_user(user)) {
			request.setAttribute("username", name);
			request.getRequestDispatcher("/log_in.jsp").forward(request, response);
		} else {

			response.sendRedirect("fail.jsp");
		}
	}
}
