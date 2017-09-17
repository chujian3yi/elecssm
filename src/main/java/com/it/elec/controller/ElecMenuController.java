package com.it.elec.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.elec.model.ElecosUser;
import com.it.elec.service.IElecMenuService;
import com.it.elec.util.LogonUtils;

/**
 * Created by Administrator on 2017/9/16.
 */
@Controller
@RequestMapping(value = "/elecMenuController")
public class ElecMenuController {

    @Autowired
    private IElecMenuService elecMenuService;

    private static  final Log logger = LogFactory.getLog(ElecMenuController.class);

    /**
     * 登录
     * @param request
     * @param response
     * @param user
     * @return
     */
    @RequestMapping(value = "/menuHome")
    public String menuHome(HttpServletRequest  request,HttpServletResponse response,ElecosUser user){
        
    	
    	//校验验证码
    	Boolean flag = LogonUtils.checkedNumber(request);
    	if (!flag) {
			return "eeror";
		}
    	if(null == user){
    		return "error";
    	}
        //参数非法
        boolean isParamInValid =StringUtils.isEmpty(user.getLogonName()) || StringUtils.isEmpty(user.getLogonPwd());
        if (isParamInValid) {
    		return "error";
		}
        ElecosUser elecosUser = elecMenuService.login(user);
        if(null==elecosUser){
        	 return "error";
        }else
        {
        	//对比页面获取的密码和elecosUser中的密码
        	//对页面密码进行加密
        	if (!user.getLogonPwd().equals(elecosUser.getLogonPwd())) {
				return "error";
			}
        }
      
        //用户存session
        request.getSession().setAttribute("globle_user", elecosUser);
        return "WEB-INF/page/menu/home";
    }
    
    
    @RequestMapping(value = "/title")
    public String title(){
    	
    	return "WEB-INF/page/menu/title";
    }
    
    @RequestMapping(value="/left")
    public String left(){
    	
    	return "WEB-INF/page/menu/left";
    }
}
