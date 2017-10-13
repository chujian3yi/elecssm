package com.it.elec.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.elec.dao.ElecosSystemDDLDao;
import com.it.elec.dao.ElecosUserDao;
import com.it.elec.model.ElecosUser;
import com.it.elec.service.IElecUserService;

@Service("elecUserService")
public class ElecUserService implements IElecUserService {
	
	@Autowired
	private ElecosUserDao elecosUserDao ;

	@Autowired
	private ElecosSystemDDLDao elecosSystemDDLDao;
	
	@Override
	public List<ElecosUser> listUsers(ElecosUser user) {
		List<ElecosUser> list = new ArrayList<ElecosUser>();
		list = elecosUserDao.listUsers(user);
		
		return list;
	}

	/**
	 * 
	 * @Tile:saveUser
	 * @Description:保存用户
	 * @Author:anphy
	 * @Return:无
	 */
	@Override
	public void saveUser(ElecosUser elecosUser) {

		elecosUserDao.saveUser(elecosUser);
	}

	/**
	 * 
	 * @Tile:checkUser
	 * @Description: 	message=1:表示登录名不能为空
	*        			message=2:表示登录名在数据库中已经存在，此时不能保存
	*        			message=3:表示登录名在数据库表不存在，此时可以保存
	 * @Author:anphy
	 * @Return:String
	 */
	@Override
	public String checkUser(ElecosUser elecosUser) {
		String message = "";
		String  logoName = elecosUser.getLogonName();
		if (StringUtils.isNotBlank(logoName)) {
			// 根据登录名查询用户表
			List<ElecosUser> list = elecosUserDao.listUsers(elecosUser);
			if (list!=null && list.size()>0) {
				message ="2";
			}else {
				message = "3";
			}
		}else {
			message ="1";
		}
		
		
		return message;
	}

	@Override
	public void delete(Integer[] userIds) {
		// TODO Auto-generated method stub
		for (Integer userId : userIds) {
			elecosUserDao.delete(userId);
		}
		
	}


	
}
