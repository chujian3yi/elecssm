/**
 * Copyright © 2017anphyYI. All rights reserved.
  
 * @Title: ElecSystemDDLService.java
 * @Prject: elecssm
 * @Package: com.it.elec.service.impl
 * @Description: TODO
 * @author: Administrator  
 * @date: 2017年9月30日 上午9:56:32
 * @version: V1.0  
 */
package com.it.elec.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.elec.dao.ElecosSystemDDLDao;
import com.it.elec.model.ElecosSystemDDL;
import com.it.elec.service.IElecSystemDDLService;

/**
 * @ClassName:ElecSystemDDLService
 * @Description:TODO
 * @author Administrator
 */

@Service
public class ElecSystemDDLService implements IElecSystemDDLService {

	
	private ElecosSystemDDLDao elecSystemDDLDao;

	public ElecosSystemDDLDao getElecSystemDDLDao() {
		return elecSystemDDLDao;
	}

	@Autowired
	public void setElecSystemDDLDao(ElecosSystemDDLDao elecSystemDDLDao) {
		this.elecSystemDDLDao = elecSystemDDLDao;
	}
	

	/**查询数据字典的数据类型列表*/
	@Override
	public List<ElecosSystemDDL> findDistinctKeyword() {
	
		
		List<ElecosSystemDDL> systemList = new ArrayList<ElecosSystemDDL>();
		
		List<Object> list = elecSystemDDLDao.findDistinctKeyword();
		if (list !=null &&list.size()>0) {
			for(Object o:list){
				ElecosSystemDDL elecosSystemDDL = new ElecosSystemDDL();
				elecosSystemDDL=(ElecosSystemDDL) o;
				systemList.add(elecosSystemDDL);
			}
		}
		
		return systemList;
	}

	/**
	 * 根据数据类型查询数据编号和数据项的值
	 */
	@Override
	public List<ElecosSystemDDL> findElecSystemDDLByKeyword(String keyword) {
		// TODO Auto-generated method stub
		
		List<ElecosSystemDDL> list = elecSystemDDLDao.findElecSystemDDLByKeyword(keyword);
		return list;
	}

	/**
	 * 1、获取页面表单的三个参数，keywordname;typeflag;itemname;
	 * 2、判断执行的保存操作是新增，还是更新。
	 * 		新增：执行插入新数据
	 * 		更新：执行删除原数据、再插入新数据
	 * 
	 */
	@Override
	public void saveElecSystemDDL(ElecosSystemDDL elecosSystemDDL) {
		/**
		 * 获取数据类型
		 */
		String keywordname = elecosSystemDDL.getKeywordname();
		/**
		 * 获取判断标志
		 * 用来判断是新增数据类型，还是对已有数据类型进行编辑修改
		 * 判断标志：typeflag="new",是新增
		 * 			typeflag="add",是更新
		 */
		String typeflag = elecosSystemDDL.getTypeflag();
		/**
		 * 获取数据项的值
		 * string类型数组，保存数据项的值
		 */
		String[] itemname = elecosSystemDDL.getItemname();
		
		/**
		 * 判断：typeflag="new",是新增，执行新增数据类型操作
		 * 		typeflag="add",是更新,执行删除新增
		 */
		if (typeflag!=null && typeflag.equals("new")) {
			this.saveElecSystemDDL(keywordname,itemname);
		}else {
			elecSystemDDLDao.delete(keywordname);
			this.saveElecSystemDDL(keywordname, itemname);
		}	
	}

	/**
	 * 
	 * @Tile:saveElecSystemDDL
	 * @Description:遍历itemname，组织po对象，执行新增
	 * @Author:anphy
	 * @Return:void
	 */
	private void saveElecSystemDDL(String keywordname, String[] itemname) {

		if (itemname!=null && itemname.length>0) {
			for (int i=0; i<itemname.length ; i++) {
				ElecosSystemDDL elecosSystemDDL = new ElecosSystemDDL();
				
				elecosSystemDDL.setKeyword(keywordname);
				elecosSystemDDL.setDdlname(itemname[i]);
				elecosSystemDDL.setDdlcode(i+1);
				elecosSystemDDL.setCreateTime(new Date());
				
				elecSystemDDLDao.saveElecSystemDDL(elecosSystemDDL);
			}
		}
	}

	@Override
	public String findElecSystemDDLByKeywordAndDdlcode(String jctId) {

		String keyword = elecSystemDDLDao.findElecSystemDDLByKeywordAndDdlcode(jctId);
		return keyword;
	}
	
	
}
