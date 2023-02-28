package bd.gov.plandiv.pdts.repository;

import bd.gov.plandiv.pdts.entity.Project;
import bd.gov.plandiv.pdts.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TrainingRepository extends JpaRepository<Training, Long>  {
    boolean existsByName(String name);
    Optional<Training> findByName(String name);
    List<Training> findAllByProjectContaining(Project project);
}
