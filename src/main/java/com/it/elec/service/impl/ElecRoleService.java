package com.it.elec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.elec.dao.ElecosPopedomDao;
import com.it.elec.dao.ElecosRoleDao;
import com.it.elec.dao.ElecosRolePopedomDao;
import com.it.elec.dao.ElecosUserDao;
import com.it.elec.dao.ElecosUserRoleDao;
import com.it.elec.model.ElecosPopedom;
import com.it.elec.model.ElecosRole;
import com.it.elec.model.ElecosRolePopedom;
import com.it.elec.model.ElecosUser;
import com.it.elec.service.IElecRoleService;

@Service
public class ElecRoleService implements IElecRoleService {

	@Autowired
	private ElecosRoleDao elecosRoleDao;
	
	@Autowired
	private ElecosUserDao elecosUserDao;
	
	@Autowired
	private ElecosPopedomDao elecosPopedomDao;

	@Autowired
	private ElecosRolePopedomDao elecosRolePopedomDao;
	
	@Autowired
	private ElecosUserRoleDao elecosUserRoleDao;
	/**
	 * find all roles 
	 */
	@Override
	public List<ElecosRole> findRoleList() {
		List<ElecosRole> list = elecosRoleDao.findRoleList();
		return list;
	}

	/**
	 * findPopedomList(Integer roleId)
	 * findPopedomList
	 * findMIDandPIDByRoleId(roleId)
	 * 
	 */
	@Override
	public List<ElecosPopedom> findPopedomList(Integer roleId) {
		/**
		 * all popedoms
		 */
		List<ElecosPopedom> list = elecosPopedomDao.findPopedomList();
		
		/**
		 * role's popedoms
		 * FORMAT:"MID@MID@MID"
		 */
		List<ElecosRolePopedom> elecosRolePopedomList = elecosRolePopedomDao.findMIDandPIDByRoleId(roleId);
		StringBuffer buffer = new StringBuffer();
		if (elecosRolePopedomList!=null && elecosRolePopedomList.size()>0) {
			for (ElecosRolePopedom elecosRolePopedom : elecosRolePopedomList) {
				buffer.append(elecosRolePopedom.getMid().toString()).append("@");
				buffer.deleteCharAt(buffer.length()-1);
			}
		}
		
		/**
		 * compare ,set flag
		 * if role's popedom contains popedom by foreach all popedoms
		 * yes:set flag=="1"
		 * no:set flag=="2"
		 */
		String popedoms = buffer.toString();
		if (list!=null && list.size()>0) {
			for (ElecosPopedom popedom : list) {
				if (popedoms.contains(popedom.getMid())) {
					//set flag=="1";
					popedom.setFlag("1");
				}else{
					//set flag=="2";
					popedom.setFlag("2");
				}
				
			}
		}
		return list;
	}

	@Override
	public List<ElecosUser> findUserListByRoleId(Integer roleId) {
		/**
		 * all users
		 */
		List<ElecosUser> list = elecosUserDao.findUsers();
		
		List<ElecosUser> users = elecosUserRoleDao.findUserListByRoleId(roleId);
		StringBuffer buffer = new StringBuffer();
		
		if (users!=null && users.size()>0) {
			for (ElecosUser elecosUser : users) {
				buffer.append(elecosUser.getUserId().toString()).append("@");
				buffer.deleteCharAt(buffer.length()-1);
			}
		}
		
		String userIDs = buffer.toString();
		if (list!=null && list.size()>0) {
			for (ElecosUser elecosUser : list) {
				if(userIDs.contains(elecosUser.getUserId().toString())){
					elecosUser.setFlag("1");
				}else {
					elecosUser.setFlag("2");
				}
			}
		}
		
		return list;
	}
}
