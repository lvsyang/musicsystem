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

public class UbanUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uid=req.getParameter("uid");
		UserDAO udao=new UserDAO();
		udao.ubanUser(uid);
		Vector<User> v =udao.findAllUser();
		HttpSession s=req.getSession();
		s.setAttribute("allUser", v);
		resp.sendRedirect(req.getContextPath()+"/admin/allUser.jsp");
	}
}
