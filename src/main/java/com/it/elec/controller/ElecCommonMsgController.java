/**
 * Copyright © 2017anphyYI. All rights reserved.
  
 * @Title: ElecCommonMsgController.java
 * @Prject: elecssm
 * @Package: com.it.elec.controller
 * @Description: TODO
 * @author: Administrator  
 * @date: 2017年9月22日 下午7:00:46
 * @version: V1.0  
 */
package com.it.elec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.stat.TableStat.Mode;
import com.it.elec.model.ElecCommonMsg;
import com.it.elec.service.IElecCommonMsgService;

/**
 * @ClassName:CommonMsgController
 * @Description:TODO
 * @author Administrator
 * @date:2017年9月22日
 */

@Controller
@RequestMapping(value="/elecCommonMsgController")
public class ElecCommonMsgController {

	
	@Autowired
	private IElecCommonMsgService elecCommonMsgService;
	
	private static final Logger logger = LoggerFactory.getLogger(ElecCommonMsgController.class);
	
	/**
	 * 查询监控信息
	 * @return
	 */
	@RequestMapping(value="/actingIndex")
	public String actingIndex(HttpServletRequest request , ElecCommonMsg msg) {
		logger.debug(" 查询监控信息 ： actingIndex");
		List<ElecCommonMsg> list = elecCommonMsgService.listCommonMsg(msg);
		ElecCommonMsg elecCommonMsg = list.get(0);
		request.setAttribute("elecCommonMsg", elecCommonMsg);
		logger.debug("查询监控信息 {} 条",list.size());
		return "WEB-INF/page/system/actingIndex";
	}


	
}
