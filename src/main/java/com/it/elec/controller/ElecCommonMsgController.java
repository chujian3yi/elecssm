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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping(value="/actingIndex")
	public String actingIndex() {
		return  "WEB-INF/page/system/actingIndex";
	}


	
}
