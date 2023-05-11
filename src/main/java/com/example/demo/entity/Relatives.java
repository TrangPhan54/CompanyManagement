package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "relatives")
public class Relatives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relativeID;

    @Column(name = "fullName")
    private String fullName;

    private int gender;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "relationship")
    private String relationship;

    @ManyToOne
    @JoinColumn(name = "employeeID")
    private Employee employee;


}
