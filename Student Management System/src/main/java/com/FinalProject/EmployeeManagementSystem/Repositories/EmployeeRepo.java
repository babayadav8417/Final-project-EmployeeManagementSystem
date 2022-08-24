package com.FinalProject.EmployeeManagementSystem.Repositories;

import com.FinalProject.EmployeeManagementSystem.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    Optional<Employee> findByEmail(String email);
}
