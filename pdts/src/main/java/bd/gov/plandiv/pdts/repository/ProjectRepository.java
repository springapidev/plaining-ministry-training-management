package bd.gov.plandiv.pdts.repository;

import bd.gov.plandiv.pdts.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long>  {
}
