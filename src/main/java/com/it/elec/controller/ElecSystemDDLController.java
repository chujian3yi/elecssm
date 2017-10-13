package com.it.elec.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.stat.TableStat.Mode;
import com.it.elec.model.ElecosSystemDDL;
import com.it.elec.service.IElecSystemDDLService;

@Controller
@RequestMapping(value="/elecSystemDDLController")
public class ElecSystemDDLController {

	@Autowired
	private IElecSystemDDLService elecSystemDDLService;
	
	
	private static final Log logger = LogFactory.getLog(ElecSystemDDLController.class);
	
	/**
	 * 
	 * @Tile:home
	 * @Description:数据字典首页显示
	 * @Author:Administrator
	 * @return
	 * @Return:String
	 */
	@RequestMapping(value = "/dictionaryIndex")
	public String home(Model model) {
		
		List<ElecosSystemDDL> systemList = elecSystemDDLService.findDistinctKeyword();
		
		model.addAttribute("systemList",systemList);
		return "WEB-INF/page/system/dictionaryIndex";
	}
	
	/**
	 * 
	 * @Tile:edit
	 * @Description:TODO
	 * @Author:anphy
	 * @CreateTime:2017年10月6日
	 * @Return:String
	 */
	@RequestMapping(value = "/dictionaryEdit")
	public String edit(Model model,ElecosSystemDDL elecosSystemDDL) {
		
		//获取数据类型
		String keyword = elecosSystemDDL.getKeyword();
		
		List<ElecosSystemDDL> systemDDLlist = elecSystemDDLService.findElecSystemDDLByKeyword(keyword);
		model.addAttribute("systemDDLlist", systemDDLlist);
		return "WEB-INF/page/system/dictionaryEdit";
	}

	/**
	 * 
	 * @Tile:save
	 * @Description:TODO
	 * @Author:anphy
	 * @CreateTime:2017年10月6日
	 * @Return:ModelAndView
	 */
	@RequestMapping(value="/saveDictionaryEdit")
	public ModelAndView save(ElecosSystemDDL elecosSystemDDL){
		elecSystemDDLService.saveElecSystemDDL(elecosSystemDDL);
		
		return new ModelAndView("redirect:/elecSystemDDLController/dictionaryIndex");
	}
	
	
	
}
