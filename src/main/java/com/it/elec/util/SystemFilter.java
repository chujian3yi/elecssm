package com.it.elec.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.it.elec.controller.ElecMenuController;
import com.it.elec.model.ElecosUser;

public class SystemFilter extends OncePerRequestFilter{
	

	private static final Logger logger = LoggerFactory.getLogger(SystemFilter.class);
	List<String> list = new ArrayList<String>();
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		list.add("/index.jsp");
		list.add("/image.jsp");
		list.add("/error.jsp");
		list.add("/errorMsg.jsp");
		list.add("/elecMenuController/logout");
		list.add("/elecMenuController/menuHome");
		
		String path = request.getServletPath();
		/**记住我的功能*/
		this.forwordIndextPage(request,path);
		/**session中不存在的path，但要执行*/
		if (list.contains(path)) {
			filterChain.doFilter(request, response);
			return;
		}
		/**粗颗粒权限控制，session级别，存在session，执行，不存在session，定向到首页*/
		ElecosUser elecosUser = (ElecosUser) request.getSession().getAttribute("globle_user") ;
		if (elecosUser!=null) {
			filterChain.doFilter(request, response);
			return;
		}
		
		request.getRequestDispatcher("/error.jsp").forward(request, response);
	}
	
	

		/**记住我的功能代码*/
	private void forwordIndextPage(HttpServletRequest request, String path) {

		if (path.equals("/index.jsp")) {
			String name = "";
			String pwd = "";
			String checked ="";
			//取出cookies
			Cookie[] cookies = request.getCookies();
			if (cookies!=null && cookies.length>0) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("logonName")) {
						name = cookie.getValue();
						try {
							name = URLDecoder.decode(name, "utf-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						checked = "checked";
					}
					if (cookie.getName().equals("logonPwd")) {
						pwd = cookie.getValue();
					}
				}
				
			}
			request.setAttribute("logonName", name);
			request.setAttribute("logonPwd", pwd);
			request.setAttribute("checked", checked);
		}
	}
}
