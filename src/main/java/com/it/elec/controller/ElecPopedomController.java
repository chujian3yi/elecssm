/**
 * Copyright © 2017anphyYI. All rights reserved.
  
 * @Title: ElecPopedomController.java
 * @Prject: elecssm
 * @Package: com.it.elec.controller
 * @Description: TODO
 * @author: Administrator  
 * @date: 2017年9月23日 下午1:22:02
 * @version: V1.0  
 */
package com.it.elec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.elec.service.IElecPopedomService;

/**
 * @ClassName:ElecPopedomController
 * @Description:TODO
 * @author Administrator
 * @date:2017年9月23日
 */

@Controller
@RequestMapping(value="/elecPopedomController")
public class ElecPopedomController {

	@Autowired
	private IElecPopedomService elecPopedomService;
	
	
}
