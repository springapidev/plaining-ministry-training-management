package bd.gov.plandiv.pdts.serviceimpl;




import bd.gov.plandiv.pdts.entity.Project;
import bd.gov.plandiv.pdts.repository.ProjectRepository;
import bd.gov.plandiv.pdts.service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;

    @Override
    public boolean save(Project project) {
       try{

           Project roleSaved = this.repository.save(project);
           if(!roleSaved.getId().equals(0)){
               log.info("Project saved Successfully!");
               return true;
           }
       }catch (Exception e){
           log.error("Error: "+e.getMessage());
           return false;
       }
        return false;
    }

    @Override
    public boolean update(Project project) {
        try{
            if(project.getId() > 0){
                this.repository.save(project);
                log.info("Project updated Successfully!");
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
    public Optional<Project> findById(Long id) {
        Optional<Project> optionalRole=this.repository.findById(id);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Project> findByName(String name) {
        Optional<Project> optionalRole= this.repository.findByName(name);
        if(optionalRole.isPresent()){
            return optionalRole;
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if(isExistById(id)) {
            this.repository.deleteById(id);
            log.info("Project Deleted Successfully!");
            return true;
        }
        return false;
    }

    @Override
    public List<Project> findAll() {
        return this.repository.findAll();
    }


}
