package com.it.elec.interceptor;

import java.lang.reflect.Method;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.it.elec.common.Constans;
import com.it.elec.exception.PermissionException;
import com.it.elec.model.ElecosUser;
import com.it.elec.util.AnnotationPermission;

public class PermissionInterceptor extends HandlerInterceptorAdapter {
	private final static Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		
		//是否执行请求的判断标志
		boolean isPass = true;
		//
		if (method.getAnnotation(AnnotationPermission.class)!=null) {
			//isPass=isCheckPermission(request,method);
			isPass=true;
		}
		/**未授权*/
		if (!isPass) {
			logger.info("没有权限：{}",method);
			throw new PermissionException("对不起~~~您没有权限操作此功能！");
		}
		return super.preHandle(request, response, handler);
	}

	/**判断当前用户是否具有当前请求标志的权限*/
	private boolean isCheckPermission(HttpServletRequest request, Method method) {
		
		AnnotationPermission annotationPermission = method.getAnnotation(AnnotationPermission.class);
		boolean isAnnotationPermission = method.isAnnotationPresent(AnnotationPermission.class); 
		//不存在用户，不执行
		ElecosUser user = (ElecosUser) request.getSession().getAttribute("globle_user");
		if (user==null) {
			logger.debug("不存在用户，不执行");
			return false;
		}
		//不存在角色，不执行
		Hashtable<String, String> ht = (Hashtable<String, String>) request.getSession().getAttribute("globle_role");
		if (ht == null) {
			logger.debug("不存在角色，不执行");
			return false;
		}
		//不存在注解，不执行
		if(!isAnnotationPermission){
			logger.info("不存在注解，不执行");
			return false;
		}
		
		boolean flag = false;
		//session上用户权限
		String pString = (String)request.getSession().getAttribute(Constans.SESSION_KEY_GLOBLE_POPEDOM);
		//方法注解上权限
		String mid = annotationPermission.mid();
		String pid = annotationPermission.pid();
		StringBuffer buffer = new StringBuffer().append(mid).append(pid);
		//鉴定权限
		if(pString.contains(buffer)) {
			flag= true;
		}
	
		return flag;
		
	}
	
}
