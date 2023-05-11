package com.example.demo.service.imp;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Relatives;
import com.example.demo.exception.DemoException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RelativesRepository;
import com.example.demo.service.RelativesService;
import com.example.demo.service.dto.RelativesDTO;
import com.example.demo.service.mapper.ProjectMapper;
import com.example.demo.service.mapper.RelativesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativesServiceImp implements RelativesService {
    private final RelativesRepository relativesRepository;
    private final EmployeeRepository employeeRepository;

    private final RelativesMapper relativesMapper = RelativesMapper.INSTANCE;
    @Override
    public List<Relatives> getAllRelatives (){
        return relativesRepository.findAll();
    }
    @Override
    public Relatives getRelativesById (Long relativeID){
        return relativesRepository.findById(relativeID).orElseThrow(DemoException::RelativesNotFound);
    }
    @Override
    public Relatives createRelatives(Long employID,RelativesDTO relativesDTO){
        Optional<Employee> employee = employeeRepository.findById(employID);
        Relatives relatives = new Relatives();
        relatives.setFullName(relativesDTO.getFullName());
        relatives.setGender(relativesDTO.getGender());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        relatives.setRelationship(relativesDTO.getRelationship());
        if (employee.isPresent())
            relatives.setEmployee(employee.get());
        return relativesRepository.save(relatives);
    }
    @Override
    public Relatives updateRelative (Long relativeID, RelativesDTO relativesDTO){
        Relatives relatives = getRelativesById(relativeID);
        relatives.setGender(relativesDTO.getGender());
        relatives.setRelationship(relativesDTO.getRelationship());
        relatives.setFullName(relativesDTO.getFullName());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        return relativesRepository.save(relatives);
    }
    @Override
    public void deleteRelativeById (Long relativeID){
        relativesRepository.deleteById(relativeID);

    }
    @Override
    public List <Relatives> getRelativeByPhoneNumber (String phoneNumber){
        return relativesRepository.findRelativeByPhoneNumber(phoneNumber);
    }
    @Override
    public List <Relatives> getRelativeByRelationshipLike (String relationship){
        return relativesRepository.findRelativeByRelationshipLike(relationship);
    }

    @Override
    public List<RelativesDTO> getRelativesByPhoneNumber(String phoneNumber) {
        return relativesMapper.toDtos(relativesRepository.getRelativesByPhoneNumber(phoneNumber));
    }

}
