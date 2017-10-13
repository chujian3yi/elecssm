package com.it.elec.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.it.elec.model.ElecosPopedom;
import com.it.elec.model.ElecosUser;
import com.it.elec.service.IElecMenuService;
import com.it.elec.service.IElecPopedomService;

/**
 * Created by Administrator on 2017/9/16.
 */
@Controller
@RequestMapping(value = "/elecMenuController")
public class ElecMenuController {

    @Autowired
    private IElecMenuService elecMenuService;
    
    @Autowired
    private IElecPopedomService elecPopedomService;

  
    private static final Logger logger = LoggerFactory.getLogger(ElecMenuController.class);

    private List<ElecosPopedom> menuList;
	public List<ElecosPopedom> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<ElecosPopedom> menuList) {
		this.menuList = menuList;
	}

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
/*    	Boolean flag = LogonUtils.checkedNumber(request);
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
		}*/
    	if("admin".equals(user.getUserName()) && "".equals(user.getLogonPwd())){
    		user.setLogonPwd("123");
    	}
        ElecosUser elecosUser = elecMenuService.login(user);
       /* if(null==elecosUser){
        	 return "error";
        }else
        {
        	//对比页面获取的密码和elecosUser中的密码
        	//对页面密码进行加密
        	if (!user.getLogonPwd().equals(elecosUser.getLogonPwd())) {
				return "error";
			}
        }*/
      
        
        
        /*
         * 查询登录名具有的权限，返回List<ElecosPopedom> list
         * */
         menuList=(elecPopedomService.findPopedomsByUser(user));
         //放置session
        request.getSession().setAttribute("menuList", menuList);
        
        
        
        //用户存session
        request.getSession().setAttribute("globle_user", elecosUser);
        return "WEB-INF/page/menu/home";
    }
    
 
    /**
     *    
     * @Tile:系统首页标题显示
     * @Description:
     * @Author:anphy
     * @CreateTime:2017年9月24日
     * @Return:跳转到首页标题页面
     */
     
    @RequestMapping(value = "/title")
    public String title(){
    	
    	return "WEB-INF/page/menu/title";
    }
    
    /**
     * 
     * @Tile:系统首页左侧菜单显示
     * @Description:TODO
     * @Author:anphy
     * @CreateTime:2017年9月24日
     * @Return:跳转到首页左侧菜单
     */
    @RequestMapping(value="/left")
    public String left(HttpServletRequest request,HttpServletResponse response){
    	//根据用户权限动态显示左侧菜单
        List<ElecosPopedom> list = new ArrayList<ElecosPopedom>();
        list =(List<ElecosPopedom>) request.getSession().getAttribute("menuList");
  
        
        String jsonData = JSON.toJSONString(list);
        logger.debug("----menu data: {} ",jsonData);
        request.getSession().setAttribute("jsondata",jsonData);
    	return "WEB-INF/page/menu/left";
    }
    
    /**
     * 
     * @Tile:logout
     * @Description:TODO
     * @Author:anphy
     * @CreateTime:2017年9月24日
     * @Return:String
     */
    @RequestMapping(value="/logout")
    public ModelAndView logout(){
    	ModelAndView andView = new ModelAndView("redirect:/index.jsp");
    	return andView;
    }
    
    /**
     * 
     * @Tile:系统首页切换全屏按钮
     * @Description:TODO
     * @Author:anphy
     * @CreateTime:2017年9月24日
     * @Return: 
     */
    @RequestMapping(value="/change")
    public String change() {
    	
    	return "WEB-INF/page/menu/change";
		
	}
    
    /**
     * 
     * @Tile:系统首页功能显示区
     * @Description:TODO
     * @Author:anphy
     * @CreateTime:2017年9月24日
     * @Return:String
     */
    @RequestMapping(value="/loading")
    private String loading() {
		return "WEB-INF/page/menu/loading";
	}

    /**
     * 
     * @Tile:alermDevice
     * @Description:TODO
     * @Author:anphy
     * @CreateTime:2017年9月24日
     * @Return:String
     */
    @RequestMapping(value="/alermDevice")
    public String alermDevice(){
    	return "WEB-INF/page/menu/alermDevice";
    }

    /**
     * 
     * @Tile:alermStation
     * @Description:TODO
     * @Author:anphy
     * @CreateTime:2017年9月24日
     * @Return:String
     */
    @RequestMapping(value="/alermStation")
    public String alermStation(){
    	return "WEB-INF/page/menu/alermStation";
    }

}


