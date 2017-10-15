package com.it.elec.dao;

import com.it.elec.model.Commonmsg1;
import com.it.elec.model.Commonmsg1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Commonmsg1Mapper {
    long countByExample(Commonmsg1Example example);

    int deleteByExample(Commonmsg1Example example);

    int deleteByPrimaryKey(Integer comId);

    int insert(Commonmsg1 record);

    int insertSelective(Commonmsg1 record);

    List<Commonmsg1> selectByExample(Commonmsg1Example example);

    Commonmsg1 selectByPrimaryKey(Integer comId);

    int updateByExampleSelective(@Param("record") Commonmsg1 record, @Param("example") Commonmsg1Example example);

    int updateByExample(@Param("record") Commonmsg1 record, @Param("example") Commonmsg1Example example);

    int updateByPrimaryKeySelective(Commonmsg1 record);

    int updateByPrimaryKey(Commonmsg1 record);
}