package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dto.User;

public class UpdateUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uid=new String(req.getParameter("uid").getBytes("ISO-8859-1"));
		String uname=new String(req.getParameter("uname").getBytes("ISO-8859-1"));
		String upassword=req.getParameter("upassword");
		String superuser=req.getParameter("superuser");
		UserDAO ud= new UserDAO();
		if(superuser.equals("2"))
		{
		User u=new User();
		u.setUid(uid);
		u.setUname(uname);
		u.setUpassword(upassword);
		u.setSuperuser(Integer.parseInt(superuser)); 
		boolean flag=ud.updateUser(u);
		UserDAO udao=new UserDAO();
		Vector<User> v =udao.findAllUser();
		HttpSession s=req.getSession();
		s.setAttribute("allUser", v);
		int uk=u.getSuperuser();
		resp.sendRedirect(req.getContextPath()+"/admin/allUser.jsp");
		}
		else 		resp.sendRedirect(req.getContextPath()+"/admin/allUser.jsp");


	}

}
