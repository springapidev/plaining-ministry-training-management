package bd.gov.plandiv.pdts.repository;

import bd.gov.plandiv.pdts.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long>  {
}
