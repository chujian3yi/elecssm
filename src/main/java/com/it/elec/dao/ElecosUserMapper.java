package com.it.elec.dao;

import com.it.elec.model.ElecosUser;
import com.it.elec.model.Person;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ElecosUserMapper {
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
}
