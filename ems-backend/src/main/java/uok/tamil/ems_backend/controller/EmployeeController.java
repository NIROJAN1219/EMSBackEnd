package uok.tamil.ems_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uok.tamil.ems_backend.dto.EmployeeDto;
import uok.tamil.ems_backend.entity.Employee;
import uok.tamil.ems_backend.service.EmployeeService;

import java.util.List;

@RestController

@RequestMapping("/api/employees")
public class EmployeeController {
     private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Build add employee rest api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build get employee rest api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }

    //get all employee
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
       List<EmployeeDto> employees=employeeService.getAllEmployees();
       return new ResponseEntity<>(employees,HttpStatus.OK);
    }
}
