package com.example.demo.service;

import com.example.demo.entity.Assignment;
import com.example.demo.service.dto.AssignmentDTO;

import java.util.List;
import java.util.Optional;

public interface AssignmentService {
    List<Assignment> getAllAssignment();
    Assignment getAssignmentById (Long assignmentId);
    Assignment createAssignment(AssignmentDTO assignmentDTO, Long employID, Long projectID);
    Assignment updateAssignment (Long assignmentID, AssignmentDTO assignmentDTO);
    void deleteAssignmentById (Long assignmentID);
    List <Assignment> getAssignmentByNumberOfHourGreaterThan  (int numberOfHour);
    List <Assignment> getAssignmentByNumberOfHourLessThan  (int numberOfHour);
}
