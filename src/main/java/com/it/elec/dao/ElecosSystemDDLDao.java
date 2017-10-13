package com.it.elec.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.it.elec.model.ElecosSystemDDL;

import javassist.compiler.ast.Keyword;

public interface ElecosSystemDDLDao {

	/**
	 * 
	 * @Tile:findDistinctKeyword
	 * @Description:查询数据字典的数据类型列表
	 * @Author:anphy
	 * @Return:List<Object>
	 */
	List<Object> findDistinctKeyword();

	/**
	 * 
	 * @Tile:findElecSystemDDLByKeyword
	 * @Description:根据数据类型查询数据编号和数据项的值
	 * @Author:anphy
	 * @Return:List<ElecosSystemDDL>
	 */
	List<ElecosSystemDDL> findElecSystemDDLByKeyword(String keyword);

	/**
	 * 
	 * @Tile:saveElecSystemDDL
	 * @Description:遍历itemname，组织po对象，执行新增
	 * @Author:anphy
	 * @Return:int
	 */
	int saveElecSystemDDL(ElecosSystemDDL elecosSystemDDL);

	/**
	 * 
	 * @Tile:delete
	 * @Description:删除
	 * @Author:anphy
	 * @Return:int
	 */
	int delete(String keywordname);

	

	/**
	 * @Tile:findElecSystemDDLByKeywordAndDdlcode
	 * @Description:TODO
	 * @Author:anphy
	 * @Return:String
	 */
	String findElecSystemDDLByKeywordAndDdlcode(@Param("jctId")String jctId);
	
	
}
