package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dao.LmusicDAO;
import cn.edu.lingnan.dto.User;

public class PlayMusicServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.获取页面数据
//		String userid = req.getParameter("userid");
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		String password2 = req.getParameter("password2");
//		String superuser = req.getParameter("superuser");
		
		
		String uid=req.getParameter("uid");
		//String kid=req.getParameter("kid");
		String kid=req.getParameter("kid");
		
		
		
		
		
		
		//2.处理数据
//		UserDAO udao=new UserDAO();
//		int superuser3 =udao.findUserByNameAndPassWord(username, password);	
//		int superuser2=Integer.parseInt(superuser);
		
		
		
		LmusicDAO ldao=new LmusicDAO();
		ldao.PlayMusic(uid, kid);
		
		
		System.out.println("目标    "+uid+" ---  "+"  ---  "+kid);
		
		
		resp.sendRedirect(req.getContextPath()+"/user/lmusic.jsp?uid="+uid);


	}
	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		        doGet(req,resp);
	}

	
	
	
	

}
