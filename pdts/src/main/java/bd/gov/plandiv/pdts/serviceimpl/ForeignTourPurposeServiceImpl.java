package bd.gov.plandiv.pdts.serviceimpl;




import bd.gov.plandiv.pdts.entity.ForeignTourPurpose;

import bd.gov.plandiv.pdts.repository.ForeignTourPurposeRepository;
import bd.gov.plandiv.pdts.service.ForeignTourPurposeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class ForeignTourPurposeServiceImpl implements ForeignTourPurposeService {
    private final ForeignTourPurposeRepository repository;

    @Override
    public boolean save(ForeignTourPurpose department) {
       try{

           ForeignTourPurpose roleSaved = this.repository.save(department);
           if(!roleSaved.getId().equals(0)){
               log.info("ForeignTourPurpose saved Successfully!");
               return true;
           }
       }catch (Exception e){
           log.error("Error: "+e.getMessage());
           return false;
       }
        return false;
    }

    @Override
    public boolean update(ForeignTourPurpose department) {
        try{
            if(department.getId() > 0){
                this.repository.save(department);
                log.info("ForeignTourPurpose updated Successfully!");
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
    public Optional<ForeignTourPurpose> findById(Long id) {
        Optional<ForeignTourPurpose> optionalRole=this.repository.findById(id);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public Optional<ForeignTourPurpose> findByName(String name) {
        Optional<ForeignTourPurpose> optionalRole= this.repository.findByName(name);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if(isExistById(id)) {
            this.repository.deleteById(id);
            log.info("ForeignTourPurpose Deleted Successfully!");
            return true;
        }
        return false;
    }

    @Override
    public List<ForeignTourPurpose> findAll() {
        return this.repository.findAll();
    }


}
