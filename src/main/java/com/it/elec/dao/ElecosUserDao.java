package com.it.elec.dao;

import com.it.elec.model.ElecosUser;
import com.it.elec.model.Person;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ElecosUserDao {
    /**
     * 插入一条记录
     * @param person
     */
    void insert(ElecosUser  user);
    
    /**
     * 查询所有
     * @return
     */
    List<ElecosUser> queryAll();

	ElecosUser findUserByUsername(ElecosUser user);

	/**
	 * 查询所有用户（未分页,条件查询）
	 * @Tile:listUsers
	 * @Description:TODO
	 * @Author:anphy
	 * @Return:List<ElecosUser>
	 */
	//TODO:
	List<ElecosUser> listUsers(ElecosUser user);

	void saveUser(ElecosUser elecosUser);

	void delete(Integer userId);

	List<ElecosUser> findUsers();

	void updateUser(ElecosUser elecosUser);

	

	
}
