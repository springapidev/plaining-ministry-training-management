package bd.gov.plandiv.pdts.repository;


import bd.gov.plandiv.pdts.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {
    Optional<Employee> findByEmail(String name);
    Optional<Employee> findByEmailAndStatus(String name,boolean status);
    boolean existsByEmail(String email);
}
