package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="assignment")
public class Assignment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long assignmentID;
    @Column(name ="number_Of_Hour")
    private int numberOfHour;

    @ManyToOne
    @JoinColumn(name = "employeeID")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name ="projectID")
    private Project project;

}
