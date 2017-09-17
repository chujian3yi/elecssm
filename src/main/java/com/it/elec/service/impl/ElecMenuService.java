package com.it.elec.service.impl;

import com.it.elec.dao.ElecosUserMapper;
import com.it.elec.dao.PersonMapper;
import com.it.elec.model.ElecosUser;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.elec.service.IElecMenuService;

import java.util.List;



/**
 * 
 */
@Service("elecMenuService")
public class ElecMenuService implements IElecMenuService{

    private ElecosUserMapper elecosUserMapper;

   
    public ElecosUserMapper getElecosUserMapper() {
        return elecosUserMapper;
    }
    @Autowired
    public void setElecosUserMapper(ElecosUserMapper elecosUserMapper) {
		this.elecosUserMapper = elecosUserMapper;
	}
    
    
	/**
	 * 验证登录名和登录密码
	 */
	@Override
	public ElecosUser login(ElecosUser user) {
		  //根据登录名查询表elecos_user
    	ElecosUser elecosUser = elecosUserMapper.findUserByUsername(user);
    	String name = elecosUser.getLogonName();
    	return elecosUser;
	}
}
