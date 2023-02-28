package bd.gov.plandiv.pdts.repository;

import bd.gov.plandiv.pdts.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long>  {
    boolean existsByName(String name);
    Optional<Project> findByName(String name);
}
