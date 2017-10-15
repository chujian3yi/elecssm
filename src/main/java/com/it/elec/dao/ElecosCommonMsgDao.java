package com.it.elec.dao;

import java.util.List;

import com.it.elec.model.ElecCommonMsg;

public interface ElecosCommonMsgDao {

	/**
	 * 查询监控信息
	 * @param msg
	 * @return
	 */
	List<ElecCommonMsg> listCommonMsg(ElecCommonMsg msg);

}
