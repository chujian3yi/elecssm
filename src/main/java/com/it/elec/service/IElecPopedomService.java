/**
 * Copyright © 2017anphyYI. All rights reserved.
  
 * @Title: IElecPopedomService.java
 * @Prject: elecssm
 * @Package: com.it.elec.service
 * @Description: TODO
 * @author: Administrator  
 * @date: 2017年9月23日 下午1:23:45
 * @version: V1.0  
 */
package com.it.elec.service;

import java.util.List;

import com.it.elec.model.ElecosPopedom;
import com.it.elec.model.ElecosUser;
import com.it.elec.model.Page;

/**
 * @ClassName:IElecPopedomService
 * @Description:TODO
 * @author Administrator
 * @date:2017年9月23日
 */
public interface IElecPopedomService {

	List<ElecosPopedom> findPopedomsByUser(ElecosUser user);

	List<ElecosPopedom> findPopedomList();

	void save(ElecosPopedom elecosPopedom);

	/**分页*/
	List<ElecosPopedom> findPopedomListPage(Page page);

	

}
