package com.sewon.spring.cloud.netflix.example.Company.controller;

import com.sewon.spring.cloud.netflix.example.Company.model.Company;
import com.sewon.spring.cloud.netflix.example.Employee.model.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    GetEmployeeCommand getEmployeeCommand;

    @Autowired
    RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    @RequestMapping(value="/{name}",method=RequestMethod.GET)
    public List<Company> getCompnays(@PathVariable String name){
        logger.info("Company service " + name);

        List<Company> companyList = new ArrayList<Company>();

        List<Employee> employeesList = getEmployeeCommand.getEmployee(name);

        companyList.add(new Company("Ybrain", "Pangyo", employeesList));

        return companyList;
    }
}
