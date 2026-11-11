package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.dto.DepartmentRequestDTO;
import com.example.employeemanagementsystem.dto.DepartmentResponseDTO;
import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.Service.DepartmentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Create Department
    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> createDepartment(
            @RequestBody DepartmentRequestDTO request) {

        Department department = new Department();

        department.setName(request.getName());
        department.setDescription(request.getDescription());

        Department saved = departmentService.saveDepartment(department);

        DepartmentResponseDTO response = new DepartmentResponseDTO();

        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setDescription(saved.getDescription());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get All Departments
    @GetMapping
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments() {

        List<DepartmentResponseDTO> response =
                departmentService.getAllDepartments()
                        .stream()
                        .map(department -> {
                            DepartmentResponseDTO dto =
                                    new DepartmentResponseDTO();

                            dto.setId(department.getId());
                            dto.setName(department.getName());
                            dto.setDescription(department.getDescription());

                            return dto;
                        })
                        .toList();

        return ResponseEntity.ok(response);
    }
}

