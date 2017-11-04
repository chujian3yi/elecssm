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

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.elec.model.ElecCommonMsg;
import com.it.elec.service.IElecCommonMsgService;

/**
 * @ClassName:CommonMsgController
 * @Description:TODO
 * @author Administrator
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
	public String actingIndex(HttpServletRequest request ) {
		logger.debug(" 查询监控信息 ： actingIndex");
		/**PageHelper.startPage(1, 10);
		 * PageInfo<ElecCommonMsg> pagehelper = new PageInfo<ElecCommonMsg>(list);
		 * logger.debug("PageInfo: {}",pagehelper);*/
		List<ElecCommonMsg> list = elecCommonMsgService.listCommonMsg();
		ElecCommonMsg elecCommonMsg = list.get(0);
		request.setAttribute("elecCommonMsg", elecCommonMsg);
		logger.debug("查询监控信息 {} 条",list.size());
		return "WEB-INF/page/system/actingIndex";
	}
	
	@RequestMapping(value="/save")
	public ModelAndView save(ElecCommonMsg elecCommonMsg){
		elecCommonMsg.setCreateTime(new Date());
		elecCommonMsgService.save(elecCommonMsg);
		
		return new ModelAndView("redirect:/elecCommonMsgController/actingIndex");
	}


	
}
