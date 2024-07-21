package com.example.PORTClaimApp.Service.Impl;

import com.example.PORTClaimApp.DTO.EmployeeDTO;
import com.example.PORTClaimApp.Entity.Employee;
import com.example.PORTClaimApp.Exception.RessourceNotFoundException;
import com.example.PORTClaimApp.Mapper.EmployeeMapper;
import com.example.PORTClaimApp.Repository.EmployeeRepository;
import com.example.PORTClaimApp.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RessourceNotFoundException("Employé non trouvé avec l'id"+employeeId));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) ->
                EmployeeMapper.mapToEmployeeDTO(employee))
                        .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new RessourceNotFoundException("Employé non trouvé avec l'id "+employeeId)
                        );
        employee.setUsername(updatedEmployee.getUsername());
        employee.setPassword(updatedEmployee.getPassword());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
           Employee employee = employeeRepository.findById(employeeId)
                   .orElseThrow(()->
                           new RessourceNotFoundException("Employé non trouvé avec l'id " + employeeId)
                           );
           employeeRepository.deleteById(employeeId);
    }
}
