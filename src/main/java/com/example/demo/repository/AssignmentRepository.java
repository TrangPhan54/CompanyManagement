package com.example.demo.repository;

import com.example.demo.entity.Assignment;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository <Assignment,Long> {
    List <Assignment> findAssignmentByNumberOfHourGreaterThan (int numberOfHour);

    List <Assignment> findAssignmentByNumberOfHourLessThan (int numberOfHour);

}
