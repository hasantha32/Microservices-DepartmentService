package com.example.DepartmentService.controller;

import com.example.DepartmentService.dto.DepartmentDTO;
import com.example.DepartmentService.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO saveDepartment = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    ResponseEntity<DepartmentDTO> getDepartment(@PathVariable(value = "department-code") String departmentCode){
        DepartmentDTO getDepartment = departmentService.getDepartment(departmentCode);
        return new ResponseEntity<>(getDepartment , HttpStatus.OK);
    }
}
