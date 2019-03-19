package com.sewon.spring.cloud.netflix.example.Company.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sewon.spring.cloud.netflix.example.Employee.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetEmployeeCommand  {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @HystrixCommand(fallbackMethod = "getFallback")
    public List<Employee> getEmployee(String name)  {
        List<Employee> employeeList = (List<Employee>)restTemplate.exchange("http://localhost:8082/company/"+name+"/employees"
          ,HttpMethod.GET,null
          ,new ParameterizedTypeReference<List<Employee>>() {}).getBody();

        return employeeList;
    }

    // fall back method
    @SuppressWarnings("unused")
    public List<Employee> getFallback(String name){
        List<Employee> usersList = new ArrayList<Employee>();
        usersList.add(new Employee(3, "Terry"));

        return usersList;
    }
}
