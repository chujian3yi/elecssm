package com.it.elec.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.it.elec.model.ElecosSystemDDL;
import com.it.elec.model.ElecosUser;
import com.it.elec.service.IElecSystemDDLService;
import com.it.elec.service.IElecUserService;

@Controller
@RequestMapping(value="/elecUserController")
public class ElecUserController{
	
	
	@Autowired
	private IElecUserService elecUserService;
	
	@Autowired
	private IElecSystemDDLService elecSystemDDLService;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(ElecUserController.class);
	
	/**
	 * 
	 * @Tile:home
	 * @Description:TODO
	 * @Author:anphy
	 * @CreateTime:2017年10月7日
	 * @Return:String
	 */
	@RequestMapping(value="/userIndex")
	public String home(HttpServletRequest request,ElecosUser user) {
		List<ElecosUser> list = elecUserService.listUsers(user);
		LOGGER.debug("用户列表： {}",list);
		request.setAttribute("userList", list);
		
		List<ElecosSystemDDL> jctUnitList = elecSystemDDLService.findElecSystemDDLByKeyword("所属单位");
		request.setAttribute("jctUnitList", jctUnitList);
		return "WEB-INF/page/system/userIndex";
	}


	/**
	 * 
	 * @Tile:userAdd
	 * @Description:获取表单数据
	 * @Author:anphy
	 * @Return:String跳转到userAdd.jsp
	 */
	@RequestMapping(value="/userAdd")
	public String userAdd(HttpServletRequest request){
		//查询性别、所属单位、职位、是否在职
		this.initSystemDDL(request);
		
		return "WEB-INF/page/system/userAdd";
	}

	/**
	 * 查询性别、所属单位、职位、是否在职
	 * @param request 
	 */
	private void initSystemDDL(HttpServletRequest request) {
		List<ElecosSystemDDL> sexList = elecSystemDDLService.findElecSystemDDLByKeyword("性别");
		request.setAttribute("sexList", sexList);
		List<ElecosSystemDDL> jctUnitList = elecSystemDDLService.findElecSystemDDLByKeyword("所属单位");
		request.setAttribute("jctUnitList", jctUnitList);
		List<ElecosSystemDDL> postList = elecSystemDDLService.findElecSystemDDLByKeyword("职位");
		request.setAttribute("postList", postList);
		List<ElecosSystemDDL> isDutyList = elecSystemDDLService.findElecSystemDDLByKeyword("是否在职");
		request.setAttribute("isDutyList", isDutyList);
	}
	
	/**
	 * 
	 * @return 
	 * @Tile:getJctUnitc
	 * @Description:TODO
	 * @Author:anphy
	 * @Return:跳转到ajax
	 */
	@RequestMapping(value="/getJctUnitc")
	@ResponseBody
	public  List<ElecosSystemDDL> getJctUnitc(ElecosUser elecosUser) {
		String keyword = elecSystemDDLService.findElecSystemDDLByKeywordAndDdlcode(elecosUser.getJctId());
		List<ElecosSystemDDL> jctList = elecSystemDDLService.findElecSystemDDLByKeyword(keyword);
		
		return jctList;
	}
	
	/**
	 * 
	 * @Tile:saveUser
	 * @Description:保存用户
	 * @Author:anphy
	 * @Return:重定向到userIndex
	 */
	@RequestMapping(value="/saveUser")
	public String saveUser(ElecosUser elecosUser) {
		elecosUser.setState("1");
		elecosUser.setCreateTime(new Date());
		elecosUser.setUpdateTime(new Date());
		
		elecUserService.saveUser(elecosUser);
		
		return "WEB-INF/page/system/close";
	}
	
	/**
	 * 
	 * @Tile:checkUser
	 * @Description:TODO检查登录名是否出现重复
	 * @Author:anphy
	 * @Return:String
	 */
	@RequestMapping(value="/checkUser")
	@ResponseBody
	public String checkUser(ElecosUser elecosUser) {
	
		//根据登录名查询用户表，返回message的值
		String message = elecUserService.checkUser(elecosUser);
		return message;
	}
	
	/**
	 * 
	 * @Tile:userEdit
	 * @Description:TODO
	 * @Author:anphy
	 * @Return:String
	 */
	@RequestMapping(value="/userEdit")
	private String userEdit(HttpServletRequest request ,ElecosUser elecosUser) {
		String viewflag = elecosUser.getViewflag();
		List<ElecosUser> usersList = elecUserService.listUsers(elecosUser);
		ElecosUser user = usersList.get(0);
		user.setViewflag(viewflag);
		request.setAttribute("user", user);
		this.initSystemDDL(request);
		return "WEB-INF/page/system/userEdit";
	}
	
	@RequestMapping(value="/delete" )
	public ModelAndView delete( @RequestParam ("userId") Integer[] userIds ) {
		if (userIds!=null && userIds.length>0) {
				elecUserService.delete(userIds);
			}
		
		return new ModelAndView("redirect:/elecUserController/userIndex");
		
	}
}