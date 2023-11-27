package com.example.DepartmentService.service;

import com.example.DepartmentService.dto.DepartmentDTO;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartment(String code);
}
