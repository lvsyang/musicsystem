package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dao.LmusicDAO;
import cn.edu.lingnan.dto.User;
import cn.edu.lingnan.dto.Lmusic;
import cn.edu.lingnan.dto.Music;



public class MusicUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		///***
		String kid=req.getParameter("kid");
		String mid=req.getParameter("mid");
		String mname=new String(req.getParameter("mname").getBytes("ISO-8859-1"));
		System.out.println("得到：："+kid+"   "+mid+"   "+mname+"     ");
		///***
		LmusicDAO md=new LmusicDAO();
		Music m =new Music();
		m.setKid(kid);
		m.setMname(mname);
		m.setMid(mid);
		boolean flag1=md.updateMusic(m);
		LmusicDAO mdao=new LmusicDAO();
		Vector<Music> v =mdao.findLmusic();
		HttpSession s=req.getSession();
		//System.out.println("得到：："+kid+"   "+mid+"   "+mname+"     ");
		resp.sendRedirect(req.getContextPath()+"/admin/allMusic.jsp");

	}

}
