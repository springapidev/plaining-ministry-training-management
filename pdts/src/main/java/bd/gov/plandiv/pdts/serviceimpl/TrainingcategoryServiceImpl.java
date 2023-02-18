package bd.gov.plandiv.pdts.serviceimpl;


import bd.gov.plandiv.pdts.entity.TrainingCategory;
import bd.gov.plandiv.pdts.repository.TrainingCategoryRepository;
import bd.gov.plandiv.pdts.service.TrainingCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class TrainingcategoryServiceImpl implements TrainingCategoryService {
    private final TrainingCategoryRepository repository;

    @Override
    public boolean save(TrainingCategory trainingCategory) {
       try{

           TrainingCategory roleSaved = this.repository.save(trainingCategory);
           if(!roleSaved.getId().equals(0)){
               log.info("TrainingCategory saved Successfully!");
               return true;
           }
       }catch (Exception e){
           log.error("Error: "+e.getMessage());
           return false;
       }
        return false;
    }

    @Override
    public boolean update(TrainingCategory trainingCategory) {
        try{
            if(trainingCategory.getId() > 0){
                this.repository.save(trainingCategory);
                log.info("TrainingCategory updated Successfully!");
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
    public Optional<TrainingCategory> findById(Long id) {
        Optional<TrainingCategory> optionalRole=this.repository.findById(id);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public Optional<TrainingCategory> findByName(String name) {
        Optional<TrainingCategory> optionalRole= this.repository.findByName(name);
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
    public List<TrainingCategory> findAll() {
        return this.repository.findAll();
    }

}
