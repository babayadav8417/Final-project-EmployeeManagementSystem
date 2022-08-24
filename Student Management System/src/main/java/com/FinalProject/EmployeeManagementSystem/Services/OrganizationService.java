package com.FinalProject.EmployeeManagementSystem.Services;

import com.FinalProject.EmployeeManagementSystem.Models.Organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> getAllOrganization();
    Organization saveOrganization(Organization organization);
    Organization getOrganizationById(int id);
    Organization updateOrganization(Organization organization,int id);
    void deleteOrganization(int id);

}
