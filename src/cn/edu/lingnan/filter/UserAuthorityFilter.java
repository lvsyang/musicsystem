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

public class UserAuthorityFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		//权限确认
				HttpServletRequest request=(HttpServletRequest)arg0;
				HttpServletResponse response=(HttpServletResponse)arg1;
				HttpSession session=request.getSession();
				Integer superuser=(Integer)session.getAttribute("superuser");
				String uid=(String) session.getAttribute("uid");
				
				System.out.println("PersonalAuthorityFilter : "+ superuser+"\t"+uid);
				
				//根据id改变访问页面，否则访问登录页面
				if(uid!=null&&superuser!=null)
				{
				if(superuser==0)
				{
					response.sendRedirect(request.getContextPath()+"/index.html");
				}
					else
						arg2.doFilter(arg0, arg1);
				}
				else
					response.sendRedirect(request.getContextPath()+"/index.html");
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
