package com.it.elec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
		System.out.println(popedomList.get(5).isIsParent());
		request.setAttribute("popedomList", popedomList);
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
		request.setAttribute("popedomlist", popedomlist);
		
		/**
		 * 根据roleId查询role_user联合表，返回userId,查询user表，返回userList
		 */
		
		List<ElecosUser> userList = elecRoleService.findUserListByRoleId(roleId);
		return "WEB-INF/page/system/roleEdit";
	}
}
