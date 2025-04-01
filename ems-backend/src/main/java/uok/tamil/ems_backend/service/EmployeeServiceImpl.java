package uok.tamil.ems_backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uok.tamil.ems_backend.dto.EmployeeDto;
import uok.tamil.ems_backend.entity.Employee;
import uok.tamil.ems_backend.exception.ResourceNotFoundException;
import uok.tamil.ems_backend.mapper.EmployeeMapper;
import uok.tamil.ems_backend.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee createEmployee =employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee is not exists with given Id:"+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee) ->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());

    }
}
