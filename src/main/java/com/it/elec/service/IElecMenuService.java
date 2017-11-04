package com.it.elec.service;

import com.it.elec.model.ElecosRole;
import com.it.elec.model.ElecosUser;

import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */
public interface IElecMenuService {

	ElecosUser login(ElecosUser user);

	List<ElecosRole> getRoleListByUser(ElecosUser elecosUser);
}
