package com.example.demo.service;

import com.example.demo.entity.Relatives;
import com.example.demo.service.dto.RelativesDTO;

import java.util.List;
import java.util.Optional;

public interface RelativesService {
    List<Relatives> getAllRelatives ();
    Relatives getRelativesById (Long relativeID);
    Relatives createRelatives(Long employID, RelativesDTO relativesDTO);
    Relatives updateRelative (Long relativeID, RelativesDTO relativesDTO);
    void deleteRelativeById (Long relativeID);
    List <Relatives> getRelativeByPhoneNumber (String phoneNumber);
    List <Relatives> getRelativeByRelationshipLike (String relationship);

    List <RelativesDTO> getRelativesByPhoneNumber (String phoneNumber);



}
