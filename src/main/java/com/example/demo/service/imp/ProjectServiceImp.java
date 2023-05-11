package com.example.demo.service.imp;

import com.example.demo.entity.Department;
import com.example.demo.entity.Project;
import com.example.demo.exception.DemoException;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
import com.example.demo.service.dto.ProjectDTO;
import com.example.demo.service.mapper.EmployeeMapper;
import com.example.demo.service.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImp implements ProjectService {
    private final ProjectRepository projectRepository;
    private final DepartmentRepository departmentRepository;

    private ProjectMapper projectMapper = ProjectMapper.INSTANCE;


    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long projectID) {
        return projectRepository.findById(projectID)
                .orElseThrow(() -> DemoException.notFound("CannotFindProject", "Cannot find project"));
    }

    @Override
    public Project createProject(Long deptID, ProjectDTO projectDTO) {
        Optional<Department> department = departmentRepository.findById(deptID);
        Project project = new Project();
        project.setProjectName(projectDTO.getProjectName());
        project.setArea(projectDTO.getArea());
        if (department.isPresent())
            project.setDepartment(department.get());
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Long projectID, ProjectDTO projectDTO) {
        Project project = getProjectById(projectID);
        project.setProjectName(projectDTO.getProjectName());
        project.setArea(projectDTO.getArea());
        return projectRepository.save(project);
    }

    @Override
    public void deleteProjectById(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public List<Project> getProjectByProjectName(String projectName) {
        return projectRepository.findProjectByProjectName(projectName);
    }

    @Override
    public List<Project> getProjectByNameIgnoreCase(String upperCaseName) {
        return projectRepository.findProjectByProjectNameIgnoringCase(upperCaseName);
    }

    @Override
    public List<Project> getProjectByAreaIs(String area) {
        return projectRepository.findProjectByAreaIs(area);
    }

    @Override
    public List<Project> getProjectByProjectNameNotLike(String proName) {
        return projectRepository.findProjectByProjectNameNotLike(proName);
    }

    @Override
    public List<ProjectDTO> getProjectByArea(String area) {
        return projectMapper.toDtos(projectRepository.getProjectByArea(area));
    }


}
