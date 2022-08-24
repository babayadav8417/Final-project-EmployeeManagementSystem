package com.FinalProject.EmployeeManagementSystem.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "AssetsDetails")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private  String  assetsId;
    @Column
    private  String assetsName;
    @Column
    private  int assetsCurrentPrice;
    @Column
    private int assetsPurchasePrice;
}
