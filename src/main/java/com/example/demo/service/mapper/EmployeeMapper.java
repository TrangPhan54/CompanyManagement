package com.example.demo.service.mapper;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    EmployeeMapper INSTANCE= Mappers.getMapper(EmployeeMapper.class);
    @Mapping(target = "departmentName", source = "department.name")
    EmployeeDTO toDto (Employee employee);

    List<EmployeeDTO> toDtos (List<Employee> employees);
}
