package com.it.elec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.elec.model.Person;
import com.it.elec.service.IPersonService;

@Controller
@RequestMapping("/personController")
public class PersonController {
    
    private IPersonService personService;
    
    public IPersonService getPersonService() {
        return personService;
    }

    @Autowired
    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/showPerson")
    public String showPersons(Model model){
        List<Person> persons = personService.loadPersons();
        model.addAttribute("persons", persons);
        return "showperson";
    }
    
    /**
     * 登录
     * @param model
     * @return
     */
    public String index(Model model){
    	
    	return "index";
    }
}