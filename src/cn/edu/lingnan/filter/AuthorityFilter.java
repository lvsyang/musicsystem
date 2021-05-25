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
		// ����˭�����Ȩ����ʲô��
		HttpServletRequest request =(HttpServletRequest)arg0;//ǿ������ת��
		HttpServletResponse response =(HttpServletResponse)arg1;//ͬ��
		HttpSession session =request.getSession();//��ȡSession
		Integer superuser =(Integer)session.getAttribute("superuser");
		System.out.println("AuthorityFilter  :"+superuser);
		//�������Ȩ������Է�����Ӧ��ҳ�棬�����ȥȨ�޴����ҳ��
		if(superuser!=null){//�ж��Ƿ�ǿ�
			
		if(superuser==0)//û�е�¼��ȥ��¼ҳ��
			response.sendRedirect(request.getContextPath()+"/index.html");
		else
			if(superuser!=1)//Ȩ�޲�����ȥȨ�޲���ҳ��
				response.sendRedirect(request.getContextPath()+"/authority.html");
			else
				arg2.doFilter(arg0, arg1);//������ȷ��ȥ��ȥ��ҳ��
		}else
			response.sendRedirect(request.getContextPath()+"/index.html");
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
