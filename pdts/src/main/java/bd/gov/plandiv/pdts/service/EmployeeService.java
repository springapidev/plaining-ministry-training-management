package bd.gov.plandiv.pdts.service;

import bd.gov.plandiv.pdts.entity.Department;
import bd.gov.plandiv.pdts.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    boolean save(Employee employee);
    boolean update(Employee employee);
    boolean isExistById(Long id);
    boolean isExistByEmail(String name);
    Optional<Employee> findById(Long id);
    Optional<Employee> findByEmail(String email);
    boolean delete(Long id);
    List<Employee> findAll();
    List<Employee> findAllByDepartment(Department department);Employee findByEmailOrMobileOrIdNoContaining(String email, String mobile, String idNo);

 }
