package com.FinalProject.EmployeeManagementSystem.Controllers;

import com.FinalProject.EmployeeManagementSystem.Models.Employee;
import com.FinalProject.EmployeeManagementSystem.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public void employeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
        if(employee.getFirstName().length()>0 && employee.getLastName().length()>0 &&
                employee.getAddress().length()>0 && employee.getPhoneNumber().length()>0 &&
                employee.getPhoneNumber().length()<=15){
            Employee employee1 = employeeService.saveEmployee(employee);
            return new ResponseEntity<>("Created",HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Please Enter valid Data",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/login/{id}")
    public  ResponseEntity<Employee> getEmployeeById(@PathVariable("id")int id)
    {
    try{
        return new ResponseEntity<Employee>((Employee) employeeService.getOrganizationById(id),HttpStatus.OK);
    }
    catch (NoSuchElementException e){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }

    @PutMapping("{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable("id")int id, @RequestBody Employee employee)
    {
        try {
            return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")int id)
    {
        try{
            employeeService.deleteEmployee(id);
            return new ResponseEntity<String>("id no."+id+" deleted successfully in Employee",HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
