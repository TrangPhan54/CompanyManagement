package com.example.demo.service.dto;

import com.example.demo.entity.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RelativesDTO {
    private String fullName;
    private int gender;
    private String phoneNumber;
    private String relationship;
}
