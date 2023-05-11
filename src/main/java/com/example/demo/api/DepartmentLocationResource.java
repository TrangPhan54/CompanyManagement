package com.example.demo.api;

import com.example.demo.entity.DepartmentLocation;
import com.example.demo.service.DepartmentLocationService;
import com.example.demo.service.dto.DepartmentLocationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value= "/api/departmentLocations")
public class DepartmentLocationResource {
    private final DepartmentLocationService departmentLocationService;

    @GetMapping
    ResponseEntity<List<DepartmentLocation>> getAllDepartmentLocation(){
        return ResponseEntity.ok(departmentLocationService.getAllDepartmentLocation());
    }

    @GetMapping(value = "/{locationId}")
    ResponseEntity<DepartmentLocation> getDepartmentLocationById (@PathVariable("locationId") Long locationId) {
        return ResponseEntity.ok(departmentLocationService.getDepartmentLocationById(locationId));

    }

    @PostMapping(value = "/{deptID}")
    ResponseEntity<DepartmentLocation> createDepartmentLocation (@PathVariable ("deptID") Long deptID,
                                                                 @RequestBody DepartmentLocationDTO departmentLocationDTO){
        DepartmentLocation departmentLocation = departmentLocationService.createDepartmentLocation(departmentLocationDTO,deptID);
        return ResponseEntity.created(URI.create("/api/departmentLocations"+departmentLocation.getDepartmentLocationID())).body(departmentLocation);
    }

    @PutMapping(value = "/{departmentLocationId}")
    ResponseEntity<DepartmentLocation> updateDepartmentLocation(@PathVariable("departmentLocationId") Long departmentLocationId,
                                                                @RequestBody DepartmentLocationDTO departmentLocationDTO){
        DepartmentLocation departmentLocation= departmentLocationService.updateDepartmentLocation(departmentLocationId,departmentLocationDTO);
        return ResponseEntity.created(URI.create("/api/departmentLocations"+departmentLocation.getDepartmentLocationID())).body(departmentLocation);
    }

    @DeleteMapping(value = "/{departmentLocationId}")
    ResponseEntity<DepartmentLocation> deleteDepartmentLocation(@PathVariable ("departmentLocationId") Long departmentLocationId){
        departmentLocationService.deleteDepartmentLocationById(departmentLocationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/location_like")
    ResponseEntity<List<DepartmentLocation>> getDepartmentLocationByLocationLike (@RequestParam ("location") String location){
        return ResponseEntity.ok(departmentLocationService.getDepartmentLocationByLocationLike(location));
    }


}
