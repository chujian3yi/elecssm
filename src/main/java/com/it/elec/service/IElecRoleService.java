package com.it.elec.service;

import java.util.List;

import com.it.elec.model.ElecosPopedom;
import com.it.elec.model.ElecosRole;
import com.it.elec.model.ElecosUser;

public interface IElecRoleService {

	List<ElecosRole> findRoleList();

	List<ElecosPopedom> findPopedomList(Integer roleId);

	List<ElecosUser> findUserListByRoleId(Integer roleId);

}
