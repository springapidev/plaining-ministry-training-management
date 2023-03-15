package bd.gov.plandiv.pdts.serviceimpl;

import bd.gov.plandiv.pdts.entity.Department;
import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.repository.EmployeeRepository;
import bd.gov.plandiv.pdts.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean save(Employee employee) {
       try{
           employee.setRestDate(employee.getJoiningDate().plusYears(3));
           employee.setRetirementDate(employee.getDob().plusYears(59).minusDays(1));
           employee.setPassword(passwordEncoder.encode(employee.getPassword()));
           Employee roleSaved = this.repository.save(employee);
           if(!roleSaved.getId().equals(0)){
               log.info("Employee saved Successfully!");
               return true;
           }
       }catch (Exception e){
           log.error("Error: "+e.getMessage());
           return false;
       }
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        try{
            if(employee.getId() > 0){
                this.repository.save(employee);
                log.info("Employee updated Successfully!");
                return true;
            }
        }catch (Exception e){
            log.error("Error: "+e.getMessage());
            return false;
        }
        return false;
    }

    @Override
    public boolean isExistById(Long id) {
        return this.repository.existsById(id);
    }

    @Override
    public boolean isExistByEmail(String email) {
        return this.repository.existsByEmail(email);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        Optional<Employee> optionalRole=this.repository.findById(id);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        Optional<Employee> optionalRole= this.repository.findByEmail(email);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if(isExistById(id)) {
            this.repository.deleteById(id);
            log.info("Employee Deleted Successfully!");
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Employee> findAllByDepartment(Department department) {
        return this.repository.findAllByDepartment(department);
    }

    @Override
    public Employee findByEmailOrMobileOrIdNoContaining(String email, String mobile, String idNo) {
        return this.repository.findByEmailOrMobileOrIdNoContaining(email, mobile, idNo);
    }
}
