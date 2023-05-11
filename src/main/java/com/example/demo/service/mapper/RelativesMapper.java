package com.example.demo.service.mapper;

import com.example.demo.entity.Relatives;
import com.example.demo.service.dto.RelativesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface RelativesMapper {
    RelativesMapper INSTANCE = Mappers.getMapper(RelativesMapper.class);
    RelativesDTO toDto (Relatives relatives);
    List<RelativesDTO> toDtos(List<Relatives> relatives);
}
