package bd.gov.plandiv.pdts.serviceimpl;



import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.entity.Training;
import bd.gov.plandiv.pdts.entity.TrainingDetails;
import bd.gov.plandiv.pdts.repository.TrainingDetailsRepository;
import bd.gov.plandiv.pdts.service.TrainingDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class TrainingDetailsServiceImpl implements TrainingDetailsService {
    private final TrainingDetailsRepository repository;

    @Override
    public boolean save(TrainingDetails trainingDetails) {
       try{

           TrainingDetails roleSaved = this.repository.save(trainingDetails);
           if(!roleSaved.getId().equals(0)){
               log.info("TrainingDetails saved Successfully!");
               return true;
           }
       }catch (Exception e){
           log.error("Error: "+e.getMessage());
           return false;
       }
        return false;
    }

    @Override
    public boolean update(TrainingDetails trainingDetails) {
        try{
            if(trainingDetails.getId() > 0){
                this.repository.save(trainingDetails);
                log.info("TrainingDetails updated Successfully!");
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
    public Optional<TrainingDetails> findById(Long id) {
        Optional<TrainingDetails> optionalRole=this.repository.findById(id);
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
    public List<TrainingDetails> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<TrainingDetails> findAllByEmplyee(Employee employee) {
        return this.repository.findAllByEmployee(employee);
    }

    @Override
    public List<TrainingDetails> findAllByTraining(Training training) {
        return this.repository.findAllByTraining(training);
    }


}
