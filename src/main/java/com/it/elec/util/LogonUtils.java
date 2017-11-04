package com.it.elec.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.druid.stat.TableStat.Name;

public class LogonUtils {
	
	/**校验验证码*/
	public static Boolean  checkedNumber(HttpServletRequest request) {
		//从页面获取验证码
		String checkNumber = request.getParameter("checkNumber");
		if (StringUtils.isBlank(checkNumber)) {
			return false;
		}
		//从session获取验证码
		String CHECK_NUMBER_KEY = (String) request.getSession().getAttribute("CHECK_NUMBER_KEY");
		//对比
		if(!checkNumber.equals(CHECK_NUMBER_KEY)){
			return false;
		}
		return checkNumber.equals(CHECK_NUMBER_KEY);
	}
	
	/**记住我
	 * @param response 
	 * @param logonPwd 
	 * @param logonNama */
	public static void rememberMe(HttpServletRequest request,
			HttpServletResponse response, String logonNama, String logonPwd) {
		
		//解决中文字符串不能放置到cookie
		try {
			logonNama = URLEncoder.encode(logonNama, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建两个cookies
		Cookie nameCookie = new Cookie("logonName", logonNama);
		Cookie pwdCookie = new Cookie("logonPwd", logonPwd);
		//设置cookie的有效路径
		nameCookie.setPath(request.getContextPath()+"/");
		pwdCookie.setPath(request.getContextPath()+"/");
		//设置cookie存活时间
		String rememberMe = request.getParameter("rememberMe");
		if (rememberMe!=null && rememberMe.equals("yes")) {
			nameCookie.setMaxAge(60*60*24*7);
			pwdCookie.setMaxAge(60*60*24*7);
		}
		//取消有效时间
		else{
			nameCookie.setMaxAge(0);
			pwdCookie.setMaxAge(0);
		}
		
		response.addCookie(nameCookie);
		response.addCookie(pwdCookie);
	}



	

}
