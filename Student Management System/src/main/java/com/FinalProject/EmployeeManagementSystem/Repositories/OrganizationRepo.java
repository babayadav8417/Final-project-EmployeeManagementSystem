package com.FinalProject.EmployeeManagementSystem.Repositories;

import com.FinalProject.EmployeeManagementSystem.Models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrganizationRepo extends JpaRepository<Organization,Integer> {

}
