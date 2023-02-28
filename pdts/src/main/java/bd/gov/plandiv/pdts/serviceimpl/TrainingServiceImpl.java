package bd.gov.plandiv.pdts.serviceimpl;

import bd.gov.plandiv.pdts.entity.Training;
import bd.gov.plandiv.pdts.repository.TrainingRepository;
import bd.gov.plandiv.pdts.service.TrainingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
@Slf4j
public class TrainingServiceImpl implements TrainingService {
    private final TrainingRepository repository;

    @Override
    public boolean save(Training training) {
       try{
           Training roleSaved = this.repository.save(training);
           if(!roleSaved.getId().equals(0)){
               log.info("Training saved Successfully!");
               return true;
           }
       }catch (Exception e){
           log.error("Error: "+e.getMessage());
           return false;
       }
        return false;
    }

    @Override
    public boolean update(Training training) {
        try{
            if(training.getId() > 0){
                this.repository.save(training);
                log.info("Training updated Successfully!");
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
    public Optional<Training> findById(Long id) {
        Optional<Training> optionalRole=this.repository.findById(id);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Training> findByName(String name) {
        Optional<Training> optionalRole= this.repository.findByName(name);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if(isExistById(id)) {
            this.repository.deleteById(id);
            log.info("Training Deleted Successfully!");
            return true;
        }
        return false;
    }

    @Override
    public List<Training> findAll() {
        return this.repository.findAll();
    }


}
