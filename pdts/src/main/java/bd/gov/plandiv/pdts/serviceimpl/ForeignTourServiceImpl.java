package bd.gov.plandiv.pdts.serviceimpl;

import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.entity.ForeignTour;
import bd.gov.plandiv.pdts.repository.ForeignTourRepository;
import bd.gov.plandiv.pdts.service.ForeignTourService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class ForeignTourServiceImpl implements ForeignTourService {
    private final ForeignTourRepository repository;

    @Override
    public boolean save(ForeignTour foreignTour) {
       try{

           ForeignTour roleSaved = this.repository.save(foreignTour);
           if(!roleSaved.getId().equals(0)){
               log.info("ForeignTour saved Successfully!");
               return true;
           }
       }catch (Exception e){
           log.error("Error: "+e.getMessage());
           return false;
       }
        return false;
    }

    @Override
    public boolean update(ForeignTour foreignTour) {
        try{
            if(foreignTour.getId() > 0){
                this.repository.save(foreignTour);
                log.info("ForeignTour updated Successfully!");
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
    public Optional<ForeignTour> findById(Long id) {
        Optional<ForeignTour> optionalRole=this.repository.findById(id);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }



    @Override
    public boolean delete(Long id) {
        if(isExistById(id)) {
            this.repository.deleteById(id);
            log.info("ForeignTour Deleted Successfully!");
            return true;
        }
        return false;
    }

    @Override
    public List<ForeignTour> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<ForeignTour> findAllByEmployeeAndEndDateBetween(Employee employee, LocalDate startDate, LocalDate endDate) {
        return this.repository.findAllByEmployeeAndEndDateBetween(employee,startDate,endDate);
    }
    @Override
    public List<ForeignTour> findAllByEndDateBetween(LocalDate startDate, LocalDate endDate){
        return this.repository.findAllByEndDateBetween(startDate,endDate);
    }

}
