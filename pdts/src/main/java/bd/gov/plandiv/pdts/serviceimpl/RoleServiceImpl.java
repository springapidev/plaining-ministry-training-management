package bd.gov.plandiv.pdts.serviceimpl;

import bd.gov.plandiv.pdts.entity.Role;
import bd.gov.plandiv.pdts.repository.RoleRepository;
import bd.gov.plandiv.pdts.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public boolean save(Role role) {
       try{

           Role roleSaved = this.repository.save(role);
           if(!roleSaved.getId().equals(0)){
               log.info("Role saved Successfully!");
               return true;
           }
       }catch (Exception e){
           log.error("Error: "+e.getMessage());
           return false;
       }
        return false;
    }

    @Override
    public boolean update(Role role) {
        try{
            if(role.getId() > 0){
                this.repository.save(role);
                log.info("Role updated Successfully!");
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
    public Optional<Role> findById(Long id) {
        Optional<Role> optionalRole=this.repository.findById(id);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Role> findByName(String name) {
        Optional<Role> optionalRole= this.repository.findByName(name);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if(isExistById(id)) {
            this.repository.deleteById(id);
            log.info("Role Deleted Successfully!");
            return true;
        }
        return false;
    }

    @Override
    public List<Role> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Role> search(String name) {
        return this.repository.findAllByNameContainingIgnoreCase(name);
    }
}
