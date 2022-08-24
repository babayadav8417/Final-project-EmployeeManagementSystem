package com.FinalProject.EmployeeManagementSystem.Services;

import com.FinalProject.EmployeeManagementSystem.Models.Organization;
import com.FinalProject.EmployeeManagementSystem.Repositories.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService{
    @Autowired
    private OrganizationRepo organizationRepo;

    public OrganizationServiceImpl(OrganizationRepo organizationRepo){
        this.organizationRepo=organizationRepo;
    }



    @Override
    public List getAllOrganization() {
        return organizationRepo.findAll();
    }

    @Override
    public Organization getOrganizationById(int id) {
        return organizationRepo.findById(id).orElseThrow();
    }
    @Override
    public Organization saveOrganization(Organization organization) {
        return (Organization) organizationRepo.save(organization);
    }


    @Override
    public Organization updateOrganization(Organization organization,int id) {
        Organization existingOrganization=organizationRepo.findById(id).orElseThrow();
        existingOrganization.setOrganizationName(organization.getOrganizationName());
        existingOrganization.setOrganizationAddress(organization.getOrganizationAddress());
        existingOrganization.setOrganizationMobNumber(organization.getOrganizationMobNumber());
        existingOrganization.setOrganizationType(organization.getOrganizationType());
        existingOrganization.setOrganizationStrYear(organization.getOrganizationStrYear());
        organizationRepo.save(existingOrganization);
        return existingOrganization;
    }
    @Override
    public void deleteOrganization(int id) {
        organizationRepo.findById(id).orElseThrow();
        organizationRepo.deleteById(id);
    }
}
