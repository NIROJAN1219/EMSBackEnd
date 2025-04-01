package uok.tamil.ems_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uok.tamil.ems_backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}
