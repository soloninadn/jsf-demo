package com.example.jsfspringboot.service;

import com.example.jsfspringboot.model.entity.EmployeeEntity;
import com.example.jsfspringboot.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.jsfspringboot.model.bean.EmployeeBean;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeBean> getAllEmployees() {
        LOGGER.info("getAllEmployees started");
        List<EmployeeBean> employeeBeanList = mapEntityListToBeanList(employeeRepository.findAll());
        LOGGER.info("getAllEmployees end, found: {} employees", employeeBeanList.size());
        return employeeBeanList;
    }

    public EmployeeBean save(EmployeeBean employeeBean) {
        LOGGER.info("save started for employee: {}", employeeBean);
        employeeBean = mapEntityToBean(employeeRepository.save(mapBeanToEntity(employeeBean)));
        LOGGER.info("save end, for employee: {}", employeeBean);
        return employeeBean;
    }

    private List<EmployeeBean> mapEntityListToBeanList(List<EmployeeEntity> entityList) {
        return entityList.stream().map(this::mapEntityToBean).collect(Collectors.toList());
    }

    private EmployeeBean mapEntityToBean(EmployeeEntity entity) {
        return new EmployeeBean(entity.getId(), entity.getName(), entity.getDepartment(), entity.getEmail());
    }

    private EmployeeEntity mapBeanToEntity(EmployeeBean bean) {
        return new EmployeeEntity(null, bean.getName(), bean.getDepartment(), bean.getEmail());
    }

}
