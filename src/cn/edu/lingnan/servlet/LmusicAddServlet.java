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

public class LmusicAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.获取页面数据
//		String userid = req.getParameter("userid");
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		String password2 = req.getParameter("password2");
//		String superuser = req.getParameter("superuser");
		
		
		String mname=req.getParameter("mname");
		String kid=req.getParameter("kid");
		String uid=req.getParameter("uid");
		
		
		
		
		
		
		//2.处理数据
//		UserDAO udao=new UserDAO();
//		int superuser3 =udao.findUserByNameAndPassWord(username, password);	
//		int superuser2=Integer.parseInt(superuser);
		
		
		
		LmusicDAO ldao=new LmusicDAO();
		ldao.PrepInsertaLmusic(mname, kid, uid);
		
		
		System.out.println("目标    "+mname+" ---  "+kid+"  ---  "+uid);
		
//		Vector<User> v=new Vector<User>();
//		v=udao.findAllUserid();
//		boolean flag=true;
//
//		for(User u: v) {//遍历出user中的所有uid，判断是否有重复
//			if(userid.equals(u.getUid()))
//			{
//				flag=false;System.out.println("用户id重复！！！"); break;
//				
//			}
//			else continue;
//			
//		}
//		
//		if(flag==true){//如果没有重复的uid则添加该用户
//		udao.PrepInsertUser(userid,username,password,superuser2);
//		System.out.println("获取："+userid+"\t"+username+"\t"+password+"\t"+password2+"\t"+superuser);}
//
//		
//		
//		HttpSession session =req.getSession();
//		session.setAttribute("superuser",superuser3);//登录时把superuser写到session里
		//3.返回结果
//		if(flag&&userid!=null&&username!=null&&password!=null&&password2!=null&&superuser!=null
//				&&userid!=""&&username!=""&&password!=""&&password2!=""&&superuser!=""){
//			resp.sendRedirect(req.getContextPath()+"/Jumpinfiverseconds.jsp");}
//		else
//			resp.sendRedirect(req.getContextPath()+"/error.html");
		
		resp.sendRedirect(req.getContextPath()+"/user/lmusic.jsp?uid="+uid);


	}
	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		        doGet(req,resp);
	}

	
	
	
	

}
