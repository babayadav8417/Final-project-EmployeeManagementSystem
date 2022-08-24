package com.FinalProject.EmployeeManagementSystem.Models;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "OrganizationDetails")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String organizationName;
    @Column
    private String organizationAddress;
    @Column
    private String organizationMobNumber;
    @Column
    private String organizationType;
    @Column
    private long organizationStrYear;

}
