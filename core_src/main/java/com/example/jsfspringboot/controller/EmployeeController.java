package com.example.jsfspringboot.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.example.jsfspringboot.model.bean.EmployeeBean;
import com.example.jsfspringboot.service.EmployeeService;

import java.util.List;

@Component
@Scope("session")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<EmployeeBean> getEmployees() {
        return employeeService.getAllEmployees();
    }

    public String saveEmployee(EmployeeBean employeeBean) {
        employeeService.save(employeeBean);
        return "index45.xhtml";
    }
}
