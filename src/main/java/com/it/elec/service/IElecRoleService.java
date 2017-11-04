package com.it.elec.service;

import java.util.List;

import com.it.elec.model.ElecosPopedom;
import com.it.elec.model.ElecosRole;
import com.it.elec.model.ElecosUser;

public interface IElecRoleService {
	public static final String SERVICE_NAME = "com.it.elec.service.impl.ElecRoleService";

	List<ElecosRole> findRoleList();

	List<ElecosPopedom> findPopedomList(Integer roleId);

	List<ElecosUser> findUserListByRoleId(Integer roleId);

	boolean findRolePopedomByRoleId(Integer roleId, String mid, String pid);

}
