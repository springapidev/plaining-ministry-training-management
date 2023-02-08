package bd.gov.plandiv.pdts.repository;


import bd.gov.plandiv.pdts.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {
}
