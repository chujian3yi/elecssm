package com.it.elec.service;

import java.util.List;

import com.it.elec.model.ElecosUser;

public interface IElecUserService {

	
	List<ElecosUser> listUsers(ElecosUser user);

	void saveUser(ElecosUser elecosUser);

	String checkUser(ElecosUser elecosUser);

	void delete(Integer[] userIds);



}
