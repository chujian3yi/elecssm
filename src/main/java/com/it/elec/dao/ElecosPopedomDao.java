/**
 * Copyright © 2017anphyYI. All rights reserved.
  
 * @Title: ElecosPopedomDao.java
 * @Prject: elecssm
 * @Package: com.it.elec.dao
 * @Description: TODO
 * @author: Administrator  
 * @date: 2017年9月23日 下午1:33:00
 * @version: V1.0  
 */
package com.it.elec.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.it.elec.model.ElecosPopedom;
import com.it.elec.model.ElecosUser;
import com.it.elec.model.Page;

/**
 * @ClassName:ElecosPopedomDao
 * @Description:TODO
 * @author Administrator
 * @date:2017年9月23日
 */
public interface ElecosPopedomDao {

    /**
     * 插入一条记录
     * @param elecosPopedom
     */
    //void insert(ElecosPopedom elecosPopedom);
    
    /**
     * 条件查询该用户所有权限
     * @return
     */
    List<ElecosPopedom> findPopedomsByUser(ElecosUser user);

	List<ElecosPopedom> findPopedomList();

	
	/**分页
	 * 查询所有权限
	 * 
	 * */
	List<ElecosPopedom> findPopedomListPage( Page page);
	
}
