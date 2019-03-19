package com.sewon.spring.cloud.netflix.example.Employee.controller;

import com.sewon.spring.cloud.netflix.example.Employee.model.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/company")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @RequestMapping(value="/{name}/employees",method=RequestMethod.GET)
    public List<Employee> getEmployee(@PathVariable String name){
        logger.info("getEmployee "+name);

        List<Employee> itemList = new ArrayList<Employee>();
        itemList.add(new Employee(1,"Alice"));
        itemList.add(new Employee(2,"Bob"));
        return itemList;
    }
}
