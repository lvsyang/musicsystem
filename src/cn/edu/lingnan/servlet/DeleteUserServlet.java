package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dto.User;

public class DeleteUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uid=req.getParameter("uid");
		UserDAO udao=new UserDAO();
		
		
		udao.deleteUser(uid);
		
		
		
//		int n = JOptionPane.showConfirmDialog(null, "确认删除被选定的学生信息吗?", "确认删除框", JOptionPane.YES_NO_OPTION);//确定与取消界面
//		if(n == JOptionPane.YES_OPTION)
//		{
//			udao.deleteUser(uid);
//		}
//		
//		else if (n == JOptionPane.NO_OPTION){System.out.println("465465465465");}
		
		
		Vector<User> v =udao.findAllUser();
		HttpSession s=req.getSession();
		s.setAttribute("allUser", v);
		resp.sendRedirect(req.getContextPath()+"/admin/allUser.jsp");

	}
}
