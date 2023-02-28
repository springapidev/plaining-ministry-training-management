package bd.gov.plandiv.pdts.repository;


import bd.gov.plandiv.pdts.entity.Department;
import bd.gov.plandiv.pdts.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {
    Optional<Employee> findByEmail(String name);
    boolean existsByEmail(String email);
    List<Employee> findAllByDepartment(Department department);
    Employee findByEmailOrMobileOrIdNoContaining(String email, String mobile, String idNo);
}
