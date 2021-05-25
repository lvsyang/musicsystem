package cn.edu.lingnan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// 你是谁？你的权限是什么？
		HttpServletRequest request =(HttpServletRequest)arg0;//强制类型转换
		HttpServletResponse response =(HttpServletResponse)arg1;//同上
		HttpSession session =request.getSession();//获取Session
		Integer superuser =(Integer)session.getAttribute("superuser");
		System.out.println("AuthorityFilter  :"+superuser);
		//根据你的权限你可以访问相应的页面，否则会去权限错误的页面
		if(superuser!=null){//判断是否非空
			
		if(superuser==0)//没有登录，去登录页面
			response.sendRedirect(request.getContextPath()+"/index.html");
		else
			if(superuser!=1)//权限不够，去权限不够页面
				response.sendRedirect(request.getContextPath()+"/authority.html");
			else
				arg2.doFilter(arg0, arg1);//访问正确，去该去的页面
		}else
			response.sendRedirect(request.getContextPath()+"/index.html");
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
