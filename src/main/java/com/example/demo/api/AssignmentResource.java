package com.example.demo.api;

import com.example.demo.entity.Assignment;
import com.example.demo.service.AssignmentService;
import com.example.demo.service.dto.AssignmentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/api/assignments")

public class AssignmentResource {
    @Autowired
    private final AssignmentService assignmentService;

    @GetMapping
    ResponseEntity<List<Assignment>> getAllAssignment(){
        return ResponseEntity.ok(assignmentService.getAllAssignment());
    }

    @GetMapping(value ="/{assignmentId}")
    ResponseEntity <Assignment> getAssignmentById (@PathVariable("assignmentId") Long assignmentId) {
        return ResponseEntity.ok(assignmentService.getAssignmentById(assignmentId));
    }

    @PostMapping(value = "/{employeeId}/{projectId}")
    ResponseEntity<Assignment> createAssignment(@PathVariable ("employeeId") Long employeeId,
                                                @PathVariable ("projectId") Long projectId,
                                                @RequestBody AssignmentDTO assignmentDTO){
        Assignment assignment = assignmentService.createAssignment(assignmentDTO,employeeId,projectId);
        return ResponseEntity.created(URI.create("/api/assignments"+assignment.getAssignmentID())).body(assignment);

    }

    @PutMapping(value ="/{assignmentId}")
    ResponseEntity<Assignment> updateAssignment(@PathVariable ("assignmentId") Long assignmentId,
                                                @RequestBody AssignmentDTO assignmentDTO){
        Assignment assignment = assignmentService.updateAssignment(assignmentId,assignmentDTO);
        return ResponseEntity.created(URI.create("/api/assignments"+assignment.getAssignmentID())).body(assignment);
    }

    @DeleteMapping(value="/{assignmentId}")
    ResponseEntity<Assignment> deleteAssignment(@PathVariable("assignmentId") Long assignmentId){
        assignmentService.deleteAssignmentById(assignmentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/number_of_hour")
    ResponseEntity <List<Assignment>> getAssignmentByNumberOfHourGreaterThan (@RequestParam ("numberOfHour") int numberOfHour){
        return ResponseEntity.ok(assignmentService.getAssignmentByNumberOfHourGreaterThan(numberOfHour));
    }

    @GetMapping(value = "/hour")
    ResponseEntity <List<Assignment>> getAssignmentByNumberOfHourLessThan (@RequestParam ("hour") int hour){
        return ResponseEntity.ok(assignmentService.getAssignmentByNumberOfHourLessThan(hour));
    }
}
