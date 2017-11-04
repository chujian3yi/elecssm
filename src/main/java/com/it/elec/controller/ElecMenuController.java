package com.it.elec.controller;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.it.elec.exception.LogonException;
import com.it.elec.model.ElecosPopedom;
import com.it.elec.model.ElecosRole;
import com.it.elec.model.ElecosUser;
import com.it.elec.service.IElecMenuService;
import com.it.elec.service.IElecPopedomService;
import com.it.elec.util.AnnotationPermission;
import com.it.elec.util.LogonUtils;
import com.it.elec.util.MD5keyBean;

/**
 * Created by Administrator on 2017/9/16.
 */
@Controller
@RequestMapping(value = "/elecMenuController")
public class ElecMenuController {
	private static final Logger logger = LoggerFactory.getLogger(ElecMenuController.class);

    @Autowired
    private IElecMenuService elecMenuService;
    
    @Autowired
    private IElecPopedomService elecPopedomService;

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
     * @throws LogonException 
     */
    @RequestMapping(value = "/menuHome")
    public String menuHome(HttpServletRequest  request,HttpServletResponse response,ElecosUser user ,Model model) throws Exception{
    	//校验验证码
    	Boolean flag = LogonUtils.checkedNumber(request);
    	if (!flag) {
    		String errorMsg = "请输入正确的验证码";
    		throw new LogonException(errorMsg);
		}
    	if(null == user){
    		//请输入登录账号或密码
    		logger.debug("err!请输入登录账号或密码");
    		return "error";
    	}
    	
        //参数非法
        boolean isParamInValid =StringUtils.isEmpty(user.getLogonName()) || StringUtils.isEmpty(user.getLogonPwd());
        if (isParamInValid) {
        	//请输入登录账号或密码
        	logger.debug("err!请输入登录账号或密码");
    		return "error";
		}
        String logonName = user.getLogonName();
        String logonPwd = user.getLogonPwd();
        ElecosUser elecosUser = elecMenuService.login(user);
        if(null==elecosUser){
        	//该用户不存在
        	 return "error";
        }else{
        	//验证密码
        	MD5keyBean md5keyBean = new MD5keyBean();
        	String md5Password = md5keyBean.getkeyBeanofStr(logonPwd);
        	if (!md5Password.equals(elecosUser.getLogonPwd())) {
        		logger.info("密码错误!");
				return "error";
			}
        }
        //登录用户角色
        List<ElecosRole> roles = elecMenuService.getRoleListByUser(elecosUser);
        logger.debug("能不能！！！！！！！ {}",roles);
        Hashtable<Integer, String> ht = new Hashtable<Integer,String>();
        if (roles!=null && roles.size()>0) {
        	for (ElecosRole elecosRole : roles) {
				ht.put(elecosRole.getRoleId(),elecosRole.getRoleName());
			}
		}
        //用户权限
        menuList=elecPopedomService.findPopedomsByUser(elecosUser);
        String popedoms = elecPopedomService.findPopedomsByLogonName(logonName);
        //记住密码
        LogonUtils.rememberMe(request,response,logonName,logonPwd);
        //request.getSession().setAttribute("globle_role", ht);
        //权限存session
        logger.debug("用户权限(session-menuList)：{}",menuList);
        request.getSession().setAttribute("menuList", menuList);
        request.getSession().setAttribute("globle_popedom", popedoms);
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
    public String left(HttpServletRequest request,HttpServletResponse response ){
    	//根据用户权限动态显示左侧菜单
        List<ElecosPopedom> list = new ArrayList<ElecosPopedom>();
        menuList = (List<ElecosPopedom>) request.getSession().getAttribute("menuList");
        logger.debug("---- {}",menuList);
        String jsonData = JSON.toJSONString(menuList);
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
    	ModelAndView andView = new ModelAndView("redirect:/");
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


