package com.it.elec.service;

import java.util.List;

import com.it.elec.model.Person;

public interface  IPersonService {
    /**
     * 加载全部的person
     * @return
     */
    List<Person> loadPersons();
}
