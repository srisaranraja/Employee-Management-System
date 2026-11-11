package com.example.employeemanagementsystem.Service;


import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.Repository.DepartmentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get department by ID
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Department not found"));
    }

    // Add department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Update department
    public Department updateDepartment(Long id, Department updatedDepartment) {

        Department existingDepartment = getDepartmentById(id);

        existingDepartment.setName(updatedDepartment.getName());
        existingDepartment.setDescription(updatedDepartment.getDescription());

        return departmentRepository.save(existingDepartment);
    }

    // Delete department
    public void deleteDepartment(Long id) {
        Department department = getDepartmentById(id);
        departmentRepository.delete(department);
    }
}

