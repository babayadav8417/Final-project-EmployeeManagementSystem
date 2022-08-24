package com.FinalProject.EmployeeManagementSystem.Services;

import com.FinalProject.EmployeeManagementSystem.Models.Employee;


import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee saveEmployee(Employee employee);
    Employee getOrganizationById(int id);
    Employee updateEmployee(Employee employee,int id);
    void deleteEmployee(int id);

}
