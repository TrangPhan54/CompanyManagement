package com.example.demo.repository;

import com.example.demo.entity.Relatives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelativesRepository extends JpaRepository <Relatives,Long> {
    List <Relatives> findRelativeByPhoneNumber (String phoneNumber);

    List <Relatives> findRelativeByRelationshipLike (String relationship);

    List <Relatives> getRelativesByPhoneNumber (String phoneNumber);
}
