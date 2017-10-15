package com.it.elec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.it.elec.model.ElecosPopedom;
import com.it.elec.model.ElecosRole;
import com.it.elec.model.ElecosUser;
import com.it.elec.service.IElecPopedomService;
import com.it.elec.service.IElecRoleService;

@Controller
@RequestMapping(value="/elecRoleController")
public class ElecRoleController {

	@Autowired
	private IElecRoleService elecRoleService;
	
	@Autowired
	private IElecPopedomService elecPopedomService;
	
	private static final Logger Logger = LoggerFactory.getLogger(ElecRoleController.class);
	
	/**
	 * 
	 * @Tile:home
	 * @Description:TODO跳转到角色管理首页
	 * @Author:anphy
	 * @Return:String
	 */
	@RequestMapping(value="/roleIndex")
	public String home(HttpServletRequest request) {
		List<ElecosRole> roleList = elecRoleService.findRoleList();
		request.setAttribute("roleList", roleList);
		List<ElecosPopedom> popedomList = elecPopedomService.findPopedomList();
		request.setAttribute("popedomList", popedomList);
		
		/**分页*/
		/*Page page = new Page();
		page.setPageNum("1");
		page.setRows(10);*/
		/*List<ElecosPopedom> popedoms = elecPopedomService.findPopedomList();
		page.setTotalNum(popedoms.size());
		List<ElecosPopedom> list = elecPopedomService.findPopedomListPage(page);
		Logger.debug("1:popedoms {}", list.size());*/
		
		PageHelper.startPage(1, 10);
		List<ElecosPopedom> list = elecPopedomService.findPopedomList();
		Page p = (Page)list;
		Logger.debug("Page {}", p);
		return "WEB-INF/page/system/roleIndex";
	}
	
	/**
	 * 
	 * @Tile:roleEdit
	 * @Description:TODO to find role's popedoms by roleId
	 * @Author:anphy
	 * @Return:String
	 */
	@RequestMapping(value="/roleEdit")
	public String roleEdit(HttpServletRequest request ,ElecosRole elecosRole) {
		Integer roleId = elecosRole.getRoleId();
		/**
		 * 根据roleId查询role_popedom联合表，返回mid pid,查询popedom表，返回popedomList
		 */
		List<ElecosPopedom> popedomlist = elecRoleService.findPopedomList(roleId);
		request.setAttribute("popedomList", popedomlist);
		/**
		 * 根据roleId查询role_user联合表，返回userId,查询user表，返回userList
		 */
		List<ElecosUser> userList = elecRoleService.findUserListByRoleId(roleId);
		
		request.setAttribute("userList", userList);
		return "WEB-INF/page/system/roleEdit";
	}
	
	/**
	 * 
	 * @Tile:save
	 * @Description:TODO
	 * @Author:anphy
	 * @Return:ModelAndView重定向到roleIndex
	 */
	@RequestMapping(value="/saveRole")
	public ModelAndView save(ElecosPopedom elecosPopedom){
		elecPopedomService.save(elecosPopedom);
		return new ModelAndView("redirect:/elecRoleController/roleIndex");
	}
}
