package com.example.demo.repository;

import com.example.demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findProjectByProjectName(String projectName);

    List<Project> findProjectByProjectNameIgnoringCase(String upperCaseName);


    List<Project> findProjectByAreaIs(String area);

    List<Project> findProjectByProjectNameNotLike(String proName);

    @Query(value = "select * from project p where p.area like :area", nativeQuery = true)
    List<Project> getProjectByArea(@Param("area") String area);


}
