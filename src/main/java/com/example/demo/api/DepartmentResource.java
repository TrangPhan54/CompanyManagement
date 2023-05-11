package com.example.demo.api;

import com.example.demo.entity.Department;
import com.example.demo.exception.DemoException;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping(value = "/api/departments")
@RequiredArgsConstructor
public class DepartmentResource {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

//    //
//    @GetMapping(value = "/{departmentId}")
//    ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable("departmentId") Long departmentId) {
//        return ResponseEntity.ok(departmentService.getDepartmentByID(departmentId));
//    }

    @PostMapping
    ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        Department department = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.created(URI.create("/api/departments/" + department.getDepartmentID())).body(department);
    }

    @PutMapping(value = "/{departmentId}")
    ResponseEntity<Department> updateDepartment(@PathVariable("departmentId") Long departmentId, @RequestBody DepartmentDTO departmentDTO) {
        Department department = departmentService.updateDepartment(departmentId, departmentDTO);
        return ResponseEntity.created(URI.create("/api/departments/" + department.getDepartmentID())).body(department);
    }

    @DeleteMapping(value = "/{departmentId}")
    ResponseEntity<Department> deleteDepartmentById(@PathVariable("departmentId") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reports")
    ResponseEntity<List<Department>> getDepartmentByDate(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
        return ResponseEntity.ok(departmentService.getDepartmentByDate(startDate));
    }

    @GetMapping("/name")
    ResponseEntity<List<Department>> getDepartmentByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(departmentService.getDepartmentByName(name));
    }

    @GetMapping("/part_of_name")
    ResponseEntity<List<Department>> getDepartmentByContaining(@RequestParam("partOfName") String partOfName) {
        return ResponseEntity.ok(departmentService.getDepartmentByNameContaining(partOfName));
    }

    @GetMapping("/another_name")
    ResponseEntity<List<Department>> getDepartmentByNameNotLike(@RequestParam("anotherName") String anotherName) {
        return ResponseEntity.ok(departmentService.getDepartmentByNameNotLike(anotherName));
    }

    @GetMapping("/uppercase_name")
    ResponseEntity<List<Department>> getDepartmentByNameIgnoreCase(@RequestParam("upperCaseName") String upperCaseName) {
        return ResponseEntity.ok(departmentService.getDepartmentByNameIgnoreCase(upperCaseName));
    }

    @GetMapping("/get_alll")
    public ResponseEntity<List<DepartmentDTO>> getAll() {
        return ResponseEntity.ok().body(departmentService.getAll());
    }
    @GetMapping("/get_by_startdate")
    public ResponseEntity<List<DepartmentDTO>> getDepartmentByStartDate(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
        return ResponseEntity.ok().body(departmentService.getDepartmentByStartDate(startDate));
    }
    @GetMapping("/get_by_dept_name")
    ResponseEntity<List<DepartmentDTO>> getDepartmentByDepartmentName (@RequestParam ("name") @NotBlank String name){
        log.info("find department by department name {} ", name);
        if(name == null || name.isEmpty())
            throw DemoException.badRequest("departmentNameEmpty","department name is empty");
        return ResponseEntity.ok().body(departmentService.getDepartmentByDepartmentName(name));
    }
    @GetMapping("/{id}")
    public ResponseEntity <DepartmentDTO> findById (@PathVariable ("id") Long departmentId){
        return ResponseEntity.ok().body(departmentService.findById(departmentId));
    }

}
