package com.example.jsfspringboot.repository;

import com.example.jsfspringboot.model.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

    List<EmployeeEntity> findAllTest();

}