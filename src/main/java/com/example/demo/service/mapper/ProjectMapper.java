package com.example.demo.service.mapper;

import com.example.demo.entity.Department;
import com.example.demo.entity.Project;
import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.service.dto.ProjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectDTO toDto (Project project);

    List<ProjectDTO> toDtos (List<Project> projects);
}

