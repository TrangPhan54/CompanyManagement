package com.example.demo.api;

import com.example.demo.entity.Project;
import com.example.demo.exception.DemoException;
import com.example.demo.service.ProjectService;
import com.example.demo.service.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/api/projects")
public class ProjectResource  {
    private final ProjectService projectService;

    @GetMapping
    ResponseEntity<List<Project>> getAllProject (){
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping(value = "/{projectId}")
    ResponseEntity <Project>  getProjectById (@PathVariable("projectId") Long projectID) {
        return ResponseEntity.ok(projectService.getProjectById(projectID));
    }

    @PostMapping("/{deptID}")
    ResponseEntity<Project> createProject (@PathVariable("deptID") Long deptID,
                                           @RequestBody ProjectDTO projectDTO){
        Project project = projectService.createProject(deptID,projectDTO);
        return ResponseEntity.created(URI.create("/api/projects/"+project.getProjectID())).body(project);
    }

    @PutMapping(value = "/{projectID}")
    ResponseEntity<Project> updateProject (@PathVariable ("projectID") Long projectID,
                                           @RequestBody ProjectDTO projectDTO){
        Project project = projectService.updateProject(projectID,projectDTO);
        return ResponseEntity.created(URI.create("/api/projects/"+project.getProjectID())).body(project);
    }

    @DeleteMapping(value = "/{projectID}")
    ResponseEntity<Project> deleteProjectById (@PathVariable ("projectID") Long projectID){
        projectService.deleteProjectById(projectID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping (value = "/project_name")
    ResponseEntity <List<Project>> getProjectByProjectName (@RequestParam ("projectName") String projectName){
        return ResponseEntity.ok(projectService.getProjectByProjectName(projectName));
    }

    @GetMapping (value ="/uppercase_name")
    ResponseEntity <List <Project>> getProjectByNameIgnoreCase (@RequestParam ("upperCaseName") String upperCaseName){
        return ResponseEntity.ok(projectService.getProjectByNameIgnoreCase(upperCaseName));
    }

    @GetMapping(value = "/area")
    ResponseEntity <List <Project>> getProjectByAreaIs (@RequestParam ("area") String area){
        return ResponseEntity.ok(projectService.getProjectByAreaIs(area));
    }

    @GetMapping (value ="/pro_name")
    ResponseEntity <List <Project>> getProjectByProjectNameNotLike (@RequestParam ("proName") String proName) {
        return ResponseEntity.ok(projectService.getProjectByProjectNameNotLike(proName));
    }

    @GetMapping ("/get_pro")
    ResponseEntity<List<ProjectDTO>> getProjectByArea (@RequestParam ("area") String area){
        log.info("find project by area {} ", area);
        if (area == null || area.isEmpty()){
            throw DemoException.badRequest("AreaIsEmpty", "Area is empty");
        }
        return ResponseEntity.ok().body(projectService.getProjectByArea(area));
    }


}
