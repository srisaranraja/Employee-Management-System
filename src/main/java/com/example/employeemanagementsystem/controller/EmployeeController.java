package com.example.employeemanagementsystem.controller;


import com.example.employeemanagementsystem.dto.EmployeeRequestDTO;
import com.example.employeemanagementsystem.dto.EmployeeResponseDTO;
import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.Service.EmployeeService;
import com.example.employeemanagementsystem.Service.DepartmentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService,
                              DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    // Create Employee
    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(
            @RequestBody EmployeeRequestDTO request) {

        Department department =
                departmentService.getDepartmentById(request.getDepartmentId());

        Employee employee = new Employee();

        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setDepartment(department);

        Employee saved = employeeService.saveEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertToDTO(saved));
    }

    // Get All Employees
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {

        List<EmployeeResponseDTO> response =
                employeeService.getAllEmployees()
                        .stream()
                        .map(this::convertToDTO)
                        .toList();

        return ResponseEntity.ok(response);
    }

    // Get Employee By ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(
            @PathVariable Long id) {

        Employee employee = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(convertToDTO(employee));
    }

    // Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeRequestDTO request) {

        Employee employee = employeeService.getEmployeeById(id);

        Department department =
                departmentService.getDepartmentById(request.getDepartmentId());

        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setDepartment(department);

        Employee updated = employeeService.saveEmployee(employee);

        return ResponseEntity.ok(convertToDTO(updated));
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }

    // Convert Entity to DTO
    private EmployeeResponseDTO convertToDTO(Employee employee) {

        EmployeeResponseDTO dto = new EmployeeResponseDTO();

        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setPhone(employee.getPhone());
        dto.setDepartmentName(employee.getDepartment().getName());

        return dto;
    }
}
