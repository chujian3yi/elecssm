package com.it.elec.dao;

import java.util.List;

import com.it.elec.model.ElecosRolePopedom;

public interface ElecosRolePopedomDao {

	List<ElecosRolePopedom> findMIDandPIDByRoleId(Integer roleId);

	void delete(Integer roleId);

	void save(ElecosRolePopedom elecosRolePopedom);


}
