package com.ansh.controller;

import com.ansh.dto.EmployeeDTO;
import com.ansh.model.Employee;
import com.ansh.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(value = "/add/user")
    public void addOrder(@RequestBody EmployeeDTO employeeDTO) {
        employeeRepository.save(getEmployee(employeeDTO));
    }

    private Employee getEmployee(EmployeeDTO dto) {
        Employee entity = new Employee();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        return entity;
    }
}
