package com.FinalProject.EmployeeManagementSystem.Services;

import com.FinalProject.EmployeeManagementSystem.Models.Employee;
import com.FinalProject.EmployeeManagementSystem.Models.Role;
import com.FinalProject.EmployeeManagementSystem.Repositories.EmployeeRepo;
import com.FinalProject.EmployeeManagementSystem.Repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
    }


    @Override
    public List getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getOrganizationById(int id) {
        return employeeRepo.findById(id).orElseThrow();
    }

    @Autowired
    private RoleRepo roleRepo;
    @Override
    public Employee saveEmployee(Employee employee) {
        Role employeeRole=roleRepo.findByName("EMPLOYEE").orElseThrow();
        employee.getRoles().add(employeeRole);
        return employeeRepo.save(employee);
    }
    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee existingEmployee=employeeRepo.findById(id).orElseThrow();
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        employeeRepo.save(existingEmployee);
        return existingEmployee;
    }
    @Override
    public void deleteEmployee(int id) {
       Employee employee= employeeRepo.findById(id).orElseThrow();
       employee.getRoles().clear();
        employeeRepo.deleteById(id);
    }
}
