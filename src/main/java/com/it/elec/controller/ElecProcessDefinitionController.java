package com.it.elec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/workflow/elecProcessDefinitionController")
public class ElecProcessDefinitionController {

	@RequestMapping(value="/processDefinitionList")
	public String processDefinitionList() {
		return "WEB-INF/page/workflow/processDefinitionList";
	}
}
