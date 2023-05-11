package com.example.demo.api;

import com.example.demo.entity.Relatives;
import com.example.demo.exception.DemoException;
import com.example.demo.service.RelativesService;
import com.example.demo.service.dto.RelativesDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value= "/api/relatives")
public class RelativesResource {
    @Autowired
    private final RelativesService relativesService;

    @GetMapping
    ResponseEntity <List<Relatives>> getAllRelative (){
        return ResponseEntity.ok(relativesService.getAllRelatives());
    }

    @GetMapping(value = "/{relativeId}")
    ResponseEntity <Relatives> getRelativesById (@PathVariable("relativeId") Long relativeId){
        return ResponseEntity.ok(relativesService.getRelativesById(relativeId));
    }

    @PostMapping("/{employeeID}")
    ResponseEntity <Relatives> createRelative (@PathVariable ("employeeID") Long employeeID,
                                               @RequestBody RelativesDTO relativesDTO){
        Relatives relatives = relativesService.createRelatives(employeeID,relativesDTO);
        return ResponseEntity.created(URI.create("/api/relatives/"+relatives.getRelativeID())).body(relatives);

    }

    @PutMapping("/{relativeID}")
    ResponseEntity <Relatives> updateRelative (@PathVariable ("relativeID") Long relativeID,
                                               @RequestBody RelativesDTO relativesDTO) {
        Relatives relatives = relativesService.updateRelative(relativeID,relativesDTO);
        return ResponseEntity.created(URI.create("/api/relatives/"+relatives.getRelativeID())).body(relatives);

    }

    @DeleteMapping("/{relativeID}")
    ResponseEntity <Relatives> deleteRelative (@PathVariable ("relativeID") Long relativeID){
        relativesService.deleteRelativeById(relativeID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/phone_number")
    ResponseEntity <List<Relatives>> getRelativeByPhoneNumber (@RequestParam ("phoneNumber") String phoneNumber){
        return ResponseEntity.ok(relativesService.getRelativeByPhoneNumber(phoneNumber));
    }

    @GetMapping (value = "/relationship")
    ResponseEntity <List<Relatives>> getRelativeByRelationshipLike (@RequestParam ("relationship") String relationship){
        return ResponseEntity.ok(relativesService.getRelativeByRelationshipLike(relationship));
    }

    ResponseEntity<List<RelativesDTO>> getRelativesByPhoneNumber (@RequestParam ("phoneNumber") @NotBlank String phoneNumber){
        log.info("find relative by phone number {} ", phoneNumber);
        if (phoneNumber == null || phoneNumber.isEmpty()){
            throw DemoException.badRequest("phoneNumberIsEmpty"," Phone number is empty");
        }
        return ResponseEntity.ok().body(relativesService.getRelativesByPhoneNumber(phoneNumber));
    }



}
