package bd.gov.plandiv.pdts.serviceimpl;



import bd.gov.plandiv.pdts.entity.Department;
import bd.gov.plandiv.pdts.entity.FundingSourceOrg;
import bd.gov.plandiv.pdts.repository.DepartmentRepository;
import bd.gov.plandiv.pdts.repository.FundingSourceOrgRepository;
import bd.gov.plandiv.pdts.service.DepartmentService;
import bd.gov.plandiv.pdts.service.FundingSourceOrgService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class FundingSourceOrgServiceImpl implements FundingSourceOrgService {
    private final FundingSourceOrgRepository repository;

    @Override
    public boolean save(FundingSourceOrg fundingSourceOrg) {
       try{

           FundingSourceOrg fundingSourceOrg1 = this.repository.save(fundingSourceOrg);
           if(fundingSourceOrg1.getId() > 0){
               log.info("FundingSourceOrg saved Successfully!");
               return true;
           }
       }catch (Exception e){
           log.error("Error: "+e.getMessage());
           return false;
       }
        return false;
    }

    @Override
    public boolean update(FundingSourceOrg fundingSourceOrg) {
        try{
            if(fundingSourceOrg.getId() > 0){
                this.repository.save(fundingSourceOrg);
                log.info("FundingSourceOrg updated Successfully!");
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
    public Optional<FundingSourceOrg> findById(Long id) {
        Optional<FundingSourceOrg> optionalRole=this.repository.findById(id);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public Optional<FundingSourceOrg> findByName(String name) {
        Optional<FundingSourceOrg> optionalRole= this.repository.findByName(name);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if(isExistById(id)) {
            this.repository.deleteById(id);
            log.info("FundingSourceOrg Deleted Successfully!");
            return true;
        }
        return false;
    }

    @Override
    public List<FundingSourceOrg> findAll() {
        return this.repository.findAll();
    }


}
