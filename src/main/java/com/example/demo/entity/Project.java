package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="project")
public class Project {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long projectID;
    @Column (name = "area")
    private String area;
    @Column (name ="project_name")
    private String projectName;

    @ManyToOne
    @JoinColumn(name ="manage_department")
    private Department department;

}
