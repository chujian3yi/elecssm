/**
 * Copyright © 2017anphyYI. All rights reserved.
  
 * @Title: ElecCommonMsgService.java
 * @Prject: elecssm
 * @Package: com.it.elec.service.impl
 * @Description: TODO
 * @author: Administrator  
 * @date: 2017年9月22日 下午7:06:12
 * @version: V1.0  
 */
package com.it.elec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.elec.dao.ElecosCommonMsgDao;
import com.it.elec.model.ElecCommonMsg;
import com.it.elec.service.IElecCommonMsgService;

/**
 * @ClassName:ElecCommonMsgService
 * @Description:TODO
 * @author Administrator
 * @date:2017年9月22日
 */

@Service(value="elecCommonMsgService")
public class ElecCommonMsgService implements IElecCommonMsgService {

	private ElecosCommonMsgDao elecosCommonMsgDao;

	
	public ElecosCommonMsgDao getElecosCommonMsgDao() {
		return elecosCommonMsgDao;
	}

	@Autowired
	public void setElecosCommonMsgDao(ElecosCommonMsgDao elecosCommonMsgDao) {
		this.elecosCommonMsgDao = elecosCommonMsgDao;
	}

	/**
	 * 查询监控信息
	 */
	@Override
	public List<ElecCommonMsg> listCommonMsg() {
		return elecosCommonMsgDao.listCommonMsg();
	}

	@Override
	public void save(ElecCommonMsg elecCommonMsg) {
		// TODO Auto-generated method stub
		elecosCommonMsgDao.save(elecCommonMsg);
		
	}
	
}
