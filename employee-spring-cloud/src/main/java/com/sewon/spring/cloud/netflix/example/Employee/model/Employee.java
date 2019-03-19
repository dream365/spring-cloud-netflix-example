package com.sewon.spring.cloud.netflix.example.Employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    int id;
    String name;
}
