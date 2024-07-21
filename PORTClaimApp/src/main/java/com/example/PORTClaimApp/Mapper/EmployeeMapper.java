package com.example.PORTClaimApp.Mapper;

import com.example.PORTClaimApp.DTO.EmployeeDTO;
import com.example.PORTClaimApp.Entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getUsername(),
                employee.getPassword()
        );
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getUsername(),
                employeeDto.getPassword()
        );
    }
}
