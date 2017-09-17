package com.it.elec.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class LogonUtils {
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
}
