/**
 * Copyright © 2017anphyYI. All rights reserved.
  
 * @Title: IElecCommonMsgService.java
 * @Prject: elecssm
 * @Package: com.it.elec.service
 * @Description: TODO
 * @author: Administrator  
 * @date: 2017年9月22日 下午7:04:37
 * @version: V1.0  
 */
package com.it.elec.service;

import java.util.List;

import com.it.elec.model.ElecCommonMsg;

/**
 * @ClassName:IElecCommonMsgService
 * @Description:TODO
 * @author Administrator
 * @date:2017年9月22日
 */
public interface IElecCommonMsgService {

	/**
	 * 查询监控信息
	 * @return
	 */
	List<ElecCommonMsg> listCommonMsg();

	void save(ElecCommonMsg elecCommonMsg);

}
