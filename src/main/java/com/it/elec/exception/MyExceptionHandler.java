package com.it.elec.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver {

	 private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		logger.info("自定义异常处理...");
		
		ModelAndView mav = new ModelAndView();
		String message = "";
		
		if (ex instanceof LogonException ) {
			message = ((LogonException)ex).getMessage();
			mav.addObject("errorMsg", message);
			mav.setViewName("error");
			logger.warn("err msg: {}",ex.getMessage());
			logger.warn("登录异常：err:\r\n{}",ex);
		}
		if (ex instanceof PermissionException) {
			message = ((PermissionException)ex).getMessage();
			mav.addObject("errorMsg", message);
			mav.setViewName("error");
			logger.warn("err msg: {}",ex.getMessage());
			logger.warn("权限异常：err:{} err:\r\n{}",ex);
		}
		return mav;
	}

}
