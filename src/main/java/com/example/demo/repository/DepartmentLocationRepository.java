package com.example.demo.repository;

import com.example.demo.entity.DepartmentLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentLocationRepository extends JpaRepository <DepartmentLocation,Long> {

    List <DepartmentLocation> findDepartmentLocationByLocationLike (String location);

}
