package com.example.demo.service;

import com.example.demo.entity.DepartmentLocation;
import com.example.demo.service.dto.DepartmentLocationDTO;

import java.util.List;
import java.util.Optional;

public interface DepartmentLocationService {
    List<DepartmentLocation> getAllDepartmentLocation();
    DepartmentLocation getDepartmentLocationById(Long departmentLocationId);
    DepartmentLocation createDepartmentLocation(DepartmentLocationDTO departmentLocationDTO, Long deptID);
    DepartmentLocation updateDepartmentLocation (Long deptID,DepartmentLocationDTO departmentLocationDTO);
    void deleteDepartmentLocationById (Long departmentLocationId);
    List <DepartmentLocation> getDepartmentLocationByLocationLike (String location);
}
