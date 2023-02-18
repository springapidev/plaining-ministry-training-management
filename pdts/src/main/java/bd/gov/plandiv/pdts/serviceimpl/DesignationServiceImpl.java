package bd.gov.plandiv.pdts.serviceimpl;


import bd.gov.plandiv.pdts.entity.Designation;
import bd.gov.plandiv.pdts.repository.DesignationRepository;
import bd.gov.plandiv.pdts.service.DesignationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class DesignationServiceImpl implements DesignationService {
    private final DesignationRepository repository;

    @Override
    public boolean save(Designation designation) {
       try{

           Designation roleSaved = this.repository.save(designation);
           if(!roleSaved.getId().equals(0)){
               log.info("Designation saved Successfully!");
               return true;
           }
       }catch (Exception e){
           log.error("Error: "+e.getMessage());
           return false;
       }
        return false;
    }

    @Override
    public boolean update(Designation designation) {
        try{
            if(designation.getId() > 0){
                this.repository.save(designation);
                log.info("Designation updated Successfully!");
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
    public Optional<Designation> findById(Long id) {
        Optional<Designation> optionalRole=this.repository.findById(id);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Designation> findByName(String name) {
        Optional<Designation> optionalRole= this.repository.findByName(name);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if(isExistById(id)) {
            this.repository.deleteById(id);
            log.info("Designation Deleted Successfully!");
            return true;
        }
        return false;
    }

    @Override
    public List<Designation> findAll() {
        return this.repository.findAll();
    }
}
