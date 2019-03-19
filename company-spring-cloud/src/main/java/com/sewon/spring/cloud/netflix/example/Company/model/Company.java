package com.sewon.spring.cloud.netflix.example.Company.model;

import com.sewon.spring.cloud.netflix.example.Employee.model.Employee;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {
    String name;
    String location;
    List<Employee> employeeList;
}


