package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.LmusicDAO;
import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dto.Music;
import cn.edu.lingnan.dto.User;

public class MusicUbanServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String mid=req.getParameter("mid");
		LmusicDAO mdao=new LmusicDAO();
		mdao.ubanMsuic(mid);
		
		
		Vector<Music> v =mdao.findLmusic();
		HttpSession s=req.getSession();
		//System.out.println("µÃµ½£º£º"+kid+"   "+mid+"   "+mname+"     ");
		resp.sendRedirect(req.getContextPath()+"/admin/allMusic.jsp");
	}
}