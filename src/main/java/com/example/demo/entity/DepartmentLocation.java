package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departmentLocation")
public class DepartmentLocation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long departmentLocationID;
    @Column
    private String location;

    @ManyToOne
    @JoinColumn(name = "deptID")
    private Department department;

}
