package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.service.dto.ProjectDTO;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAllProjects ();
    Project getProjectById (Long projectID);
    Project createProject(Long deptID, ProjectDTO projectDTO);
    Project updateProject (Long projectID,ProjectDTO projectDTO);
    void deleteProjectById (Long projectId);
    List <Project> getProjectByProjectName (String projectName);
    List <Project> getProjectByNameIgnoreCase (String upperCaseName);
    List <Project> getProjectByAreaIs (String area);
    List <Project> getProjectByProjectNameNotLike (String proName);

    List <ProjectDTO> getProjectByArea (String area);

}
