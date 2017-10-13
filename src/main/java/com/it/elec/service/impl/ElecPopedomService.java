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
import com.it.elec.model.ElecosPopedom;
import com.it.elec.model.ElecosUser;
import com.it.elec.service.IElecPopedomService;

/**
 * @ClassName:ElecPopedomService
 * @Description:TODO
 * @author Administrator
 */

@Service("elecPopedomService")
public class ElecPopedomService implements IElecPopedomService {


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
		// TODO Auto-generated method stub
		List<ElecosPopedom> list = elecosPopedomDao.findPopedomList();
		return list;
	}


	
	
}
