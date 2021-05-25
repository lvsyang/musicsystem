package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDAO;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.获取页面数据
		String username = req.getParameter("uid");
		String password = req.getParameter("password");
		System.out.println("获取："+username+"\t"+password+"\t"+password);
		//2.处理数据
		UserDAO udao=new UserDAO();
		int ban=udao.bbb(username, password);
		int superuser =udao.findUserByuidAndPassWord(username, password);	
		System.out.println("获取："+username+"\t"+password+"\t"+superuser);
		HttpSession session =req.getSession();
		session.setAttribute("superuser",superuser);//登录时把superuser写到session里
		session.setAttribute("uid",username);
		//3.返回结果
		if(superuser!=0&&ban==0)
			resp.sendRedirect(req.getContextPath()+"/ok.jsp?uid="+username);
//		else if(superuser==2&&ban==0)
//			resp.sendRedirect(req.getContextPath()+"/userok.html");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");


	}
	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		        doGet(req,resp);
	}

	
	
	
	

}
