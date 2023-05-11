package com.example.demo.service.imp;

import com.example.demo.entity.Department;
import com.example.demo.entity.DepartmentLocation;
import com.example.demo.exception.DemoException;
import com.example.demo.repository.DepartmentLocationRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentLocationService;
import com.example.demo.service.dto.DepartmentLocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentLocationServiceImp implements DepartmentLocationService {
    private final DepartmentLocationRepository departmentLocationRepository;
    private final DepartmentRepository departmentRepository;
    @Override
    public List<DepartmentLocation> getAllDepartmentLocation() {
        return departmentLocationRepository.findAll();
    }
    @Override
    public DepartmentLocation getDepartmentLocationById(Long departmentLocationId) {
        return departmentLocationRepository.findById(departmentLocationId).orElseThrow(DemoException::DepartmentLocationNotFound);
    }
    @Override

    public DepartmentLocation createDepartmentLocation(DepartmentLocationDTO departmentLocationDTO, Long deptID) {
        Optional<Department> department = departmentRepository.findById(deptID);
        DepartmentLocation departmentLocation = new DepartmentLocation();
        departmentLocation.setLocation(departmentLocationDTO.getLocation());
        if (department.isPresent()) {
            departmentLocation.setDepartment(department.get());
        }
        return departmentLocationRepository.save(departmentLocation);


    }
    @Override
    public DepartmentLocation updateDepartmentLocation (Long deptID,DepartmentLocationDTO departmentLocationDTO){
        DepartmentLocation departmentLocation = getDepartmentLocationById(deptID);
        departmentLocation.setLocation(departmentLocationDTO.getLocation());
        return departmentLocationRepository.save(departmentLocation);
    }
    @Override
    public void deleteDepartmentLocationById (Long departmentLocationId){
        departmentLocationRepository.deleteById(departmentLocationId);
    }
    @Override
    public List <DepartmentLocation> getDepartmentLocationByLocationLike (String location){
        return departmentLocationRepository.findDepartmentLocationByLocationLike("%"+location+"%");
    }


}
