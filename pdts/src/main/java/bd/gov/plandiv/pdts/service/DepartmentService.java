package bd.gov.plandiv.pdts.service;

import bd.gov.plandiv.pdts.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    boolean save(Department department);
    boolean update(Department department);
    boolean isExistById(Long id);
    boolean isExistByName(String name);
    Optional<Department> findById(Long id);
    Optional<Department> findByName(String name);
    boolean delete(Long id);
    List<Department> findAll();


}
