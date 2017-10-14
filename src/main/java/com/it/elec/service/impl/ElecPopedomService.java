/**
 * Copyright © 2017anphyYI. All rights reserved.
  
 * @Title: ElecPopedomService.java
 * @Prject: elecssm
 * @Package: com.it.elec.service.impl
 * @Description: TODO
 * @author: Administrator  
 * @date: 2017年9月23日 下午1:26:21
 * @version: V1.0  
 */
package com.it.elec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.elec.dao.ElecosPopedomDao;
import com.it.elec.dao.ElecosUserRoleDao;
import com.it.elec.model.ElecosPopedom;
import com.it.elec.model.ElecosUser;
import com.it.elec.model.ElecosUserRole;
import com.it.elec.service.IElecPopedomService;

/**
 * @ClassName:ElecPopedomService
 * @Description:TODO
 * @author Administrator
 */

@Service("elecPopedomService")
public class ElecPopedomService implements IElecPopedomService {


	@Autowired
	private ElecosUserRoleDao elecosUserRoleDao;
	
	private ElecosPopedomDao elecosPopedomDao;

	public ElecosPopedomDao getElecosPopedomDao() {
		return elecosPopedomDao;
	}

	@Autowired
	public void setElecosPopedomDao(ElecosPopedomDao elecosPopedomDao) {
		this.elecosPopedomDao = elecosPopedomDao;
	}

	/**
	 * 
	 */
	@Override
	public List<ElecosPopedom> findPopedomsByUser(ElecosUser user) {
		// TODO Auto-generated method stub

		List<ElecosPopedom> list =elecosPopedomDao.findPopedomsByUser(user);
		return list;
	}

	@Override
	public List<ElecosPopedom> findPopedomList() {
		List<ElecosPopedom> list = elecosPopedomDao.findPopedomList();
		return list;
	}

	/**
	 * save role_popedom
	 * save user_role
	 */
	@Override
	public void save(ElecosPopedom elecosPopedom) {
		/**get roleId*/
		Integer roleId = elecosPopedom.getRoleId();
		
		/**get String [] selectoper*/
		String[] selectoper = elecosPopedom.getSelectoper();
		
		/**get String [] selectuser*/
		String[] selectuser = elecosPopedom.getSelectuser();
		
		/**save role_popedom*/
		this.saveRolePopedom(roleId,selectoper);
		
		/**save user_role*/
		this.saveUserRole(roleId,selectuser);
		
	}

	/**
	 * 
	 * @Tile:saveUserRole
	 * @Description:TODO save role_popedom
	 * @Author:anphy
	 * @Return:void
	 */
	private void saveUserRole(Integer roleId, String[] selectuser) {
		/**delete */
		elecosUserRoleDao.delete(roleId);
		
		if (selectuser!=null && selectuser.length>0) {
			for (String id : selectuser) {
				ElecosUserRole elecosUserRole = new ElecosUserRole();
				int userId=Integer.parseInt(id);
				elecosUserRole.setUserId(userId);
				elecosUserRole.setRoleId(roleId);
				elecosUserRoleDao.save(elecosUserRole);
			}
		}
		
		
	}

	/**
	 * 
	 * @Tile:saveRolePopedom
	 * @Description:TODO save role_popedom
	 * @Author:anphy
	 * @Return:void
	 */
	private void saveRolePopedom(Integer roleId, String[] selectoper) {
		/***/
		
	}

	


	
	
}
