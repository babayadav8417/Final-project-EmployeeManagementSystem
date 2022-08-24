package com.FinalProject.EmployeeManagementSystem.Controllers;

import com.FinalProject.EmployeeManagementSystem.Models.Organization;
import com.FinalProject.EmployeeManagementSystem.Services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/Organization")
public class OrganizationController {
        @Autowired
        private OrganizationService organizationService;

        public OrganizationController(OrganizationService organizationService){
                this.organizationService=organizationService;
        }
        @GetMapping
        public ResponseEntity< List<Organization> > getAllOrganization(){
                List<Organization> organizations=organizationService.getAllOrganization();
                if (organizations.size()>0) {
                        return new ResponseEntity<>(organizations,HttpStatus.OK);
                }
                else {
                        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
        }

        @PostMapping
        public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization)
        {
                if(organization.getOrganizationName().length()>0 && organization.getOrganizationAddress().length()>0 &&
                organization.getOrganizationType().length()>0 && organization.getOrganizationMobNumber().length()<=10 && organization.getOrganizationMobNumber()
                        .length()>0 && organization.getOrganizationStrYear()>0){
                        return new ResponseEntity<Organization>(organizationService.saveOrganization(organization), HttpStatus.CREATED);
                }
                else {
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("{id}")
        public  ResponseEntity<Organization> getOrganizationById(@PathVariable("id")int id)
        {
                try{
                        return new ResponseEntity<Organization>((Organization) organizationService.getOrganizationById(id),HttpStatus.OK);
                }
                catch (NoSuchElementException e){
                        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
        }

        @PutMapping("{id}")
        public  ResponseEntity<Organization> updateOrganization(@PathVariable("id")int id, @RequestBody Organization organization)
        {
                try{
                        return new ResponseEntity<Organization>(organizationService.updateOrganization(organization,id), HttpStatus.OK);
                }
                catch (NoSuchElementException e){
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
        }

        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteOrganization(@PathVariable("id")int id)
        {
               try {
                       organizationService.deleteOrganization(id);
                       return new ResponseEntity<String>("id no."+id+" deleted successfully in Organization",HttpStatus.OK);
               }
               catch (NoSuchElementException e){
                       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
               }
        }
}
