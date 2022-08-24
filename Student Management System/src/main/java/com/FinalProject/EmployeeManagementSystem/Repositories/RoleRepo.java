package com.FinalProject.EmployeeManagementSystem.Repositories;

import com.FinalProject.EmployeeManagementSystem.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role,Integer> {
    @Query("select r from Role r where upper(r.name) like upper(?1)")
    Optional<Role> findByName(String name);

}
