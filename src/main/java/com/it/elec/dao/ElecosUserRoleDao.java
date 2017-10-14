package com.it.elec.dao;

import java.util.List;

import com.it.elec.model.ElecosRolePopedom;
import com.it.elec.model.ElecosUser;
import com.it.elec.model.ElecosUserRole;

public interface ElecosUserRoleDao {


	List<ElecosUser> findUserListByRoleId(Integer roleId);

	void delete(Integer roleId);

	void save(ElecosUserRole elecosUserRole);





}
