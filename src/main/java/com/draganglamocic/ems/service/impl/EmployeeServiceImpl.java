package com.draganglamocic.ems.service.impl;

import com.draganglamocic.ems.dto.EmployeeDto;
import com.draganglamocic.ems.entity.Employee;
import com.draganglamocic.ems.exception.ResourceNotFoundException;
import com.draganglamocic.ems.mapper.EmployeeMapper;
import com.draganglamocic.ems.repository.EmployeeRepository;
import com.draganglamocic.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + employeeId + " does not exist."));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
