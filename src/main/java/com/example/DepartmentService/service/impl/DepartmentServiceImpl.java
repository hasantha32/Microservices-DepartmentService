package com.example.DepartmentService.service.impl;

import com.example.DepartmentService.dto.DepartmentDTO;
import com.example.DepartmentService.entity.Department;
import com.example.DepartmentService.repository.DepartmentRepository;
import com.example.DepartmentService.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

//    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }
// private DepartmentRepository departmentRepository;

    private final DepartmentRepository departmentRepository;
    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        Department department = Department.builder()
                .departmentName(departmentDTO.getDepartmentName())
                .departmentDescription(departmentDTO.getDepartmentDescription())
                .departmentCode(departmentDTO.getDepartmentCode())
                .build();
//        Department departmentDTO1 = new Department(
//                departmentDTO.getId(),
//                departmentDTO.getDepartmentName(),
//                departmentDTO.getDepartmentDescription(),
//                departmentDTO.getDepartmentCode()
//        );
       Department department1 = departmentRepository.save(department);

       DepartmentDTO departmentDto =DepartmentDTO.builder()
               .id(department1.getId())
               .departmentName(department1.getDepartmentName())
               .departmentDescription(department1.getDepartmentDescription())
               .departmentCode(department1.getDepartmentCode())
               .build();

        return departmentDto;
    }

    @Override
    public DepartmentDTO getDepartment(String code) {
    Department department = departmentRepository.findByDepartmentCode(code);
    return  DepartmentDTO.builder()
            .id(department.getId())
            .departmentName(department.getDepartmentName())
            .departmentDescription(department.getDepartmentDescription())
            .departmentCode(department.getDepartmentCode())
            .build();
    }
}
