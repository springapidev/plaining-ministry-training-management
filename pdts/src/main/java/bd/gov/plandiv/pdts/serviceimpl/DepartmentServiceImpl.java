package bd.gov.plandiv.pdts.serviceimpl;



import bd.gov.plandiv.pdts.entity.Department;
import bd.gov.plandiv.pdts.repository.DepartmentRepository;
import bd.gov.plandiv.pdts.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;

    @Override
    public boolean save(Department department) {
       try{

           Department roleSaved = this.repository.save(department);
           if(!roleSaved.getId().equals(0)){
               log.info("Department saved Successfully!");
               return true;
           }
       }catch (Exception e){
           log.error("Error: "+e.getMessage());
           return false;
       }
        return false;
    }

    @Override
    public boolean update(Department department) {
        try{
            if(department.getId() > 0){
                this.repository.save(department);
                log.info("Department updated Successfully!");
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
    public boolean isExistByName(String name) {
        return this.repository.existsByName(name);
    }

    @Override
    public Optional<Department> findById(Long id) {
        Optional<Department> optionalRole=this.repository.findById(id);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Department> findByName(String name) {
        Optional<Department> optionalRole= this.repository.findByName(name);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if(isExistById(id)) {
            this.repository.deleteById(id);
            log.info("Department Deleted Successfully!");
            return true;
        }
        return false;
    }

    @Override
    public List<Department> findAll() {
        return this.repository.findAll();
    }


}
