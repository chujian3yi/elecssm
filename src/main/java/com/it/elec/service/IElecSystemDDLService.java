/**
 * Copyright © 2017anphyYI. All rights reserved.
  
 * @Title: ISystemService.java
 * @Prject: elecssm
 * @Package: com.it.elec.service
 * @Description: TODO
 * @author: Administrator  
 * @date: 2017年9月22日 下午11:10:49
 * @version: V1.0  
 */
package com.it.elec.service;

import java.util.List;

import com.it.elec.model.ElecosSystemDDL;

/**
 * @ClassName:IElecSystemDDLService
 * @Description:TODO
 * @author Administrator
 * @date:2017年9月22日
 */
public interface IElecSystemDDLService {

	/*查询数据字典的数据类型列表*/
	List<ElecosSystemDDL> findDistinctKeyword();

	/*根据数据类型查询数据编号和数据项的值*/
	List<ElecosSystemDDL> findElecSystemDDLByKeyword(String keyword);

	void saveElecSystemDDL(ElecosSystemDDL elecosSystemDDL);

	String findElecSystemDDLByKeywordAndDdlcode(String jctId);



	
}
