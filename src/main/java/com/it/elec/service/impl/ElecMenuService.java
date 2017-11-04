package com.it.elec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.elec.dao.ElecosRoleDao;
import com.it.elec.dao.ElecosUserDao;
import com.it.elec.dao.ElecosUserRoleDao;
import com.it.elec.model.ElecosRole;
import com.it.elec.model.ElecosUser;
import com.it.elec.service.IElecMenuService;



/**
 * 
 */
@Service("elecMenuService")
public class ElecMenuService implements IElecMenuService{

	@Autowired
	private ElecosUserRoleDao elecosUserRoleDao;

    private ElecosUserDao elecosUserDao;
	public ElecosUserDao getElecosUserDao() {
		return elecosUserDao;
	}

    @Autowired
	public void setElecosUserDao(ElecosUserDao elecosUserDao) {
		this.elecosUserDao = elecosUserDao;
	}



	/**
	 * 验证登录名和登录密码
	 */
	@Override
	public ElecosUser login(ElecosUser user) {
		  //根据登录名查询表elecos_user
    	ElecosUser elecosUser = elecosUserDao.findUserByUsername(user);
    	String name = elecosUser.getLogonName();
    	elecosUser.setState(elecosUser.getState()+1);
    	return elecosUser;
	}


	@Override
	public List<ElecosRole> getRoleListByUser(ElecosUser elecosUser) {
		List<ElecosRole> list = elecosUserRoleDao.getRoleListByUser(elecosUser);
		return list;
	}
}
