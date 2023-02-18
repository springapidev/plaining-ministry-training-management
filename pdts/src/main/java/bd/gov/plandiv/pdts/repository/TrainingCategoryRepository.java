package bd.gov.plandiv.pdts.repository;


import bd.gov.plandiv.pdts.entity.TrainingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainingCategoryRepository extends JpaRepository<TrainingCategory, Long>  {
    boolean existsByName(String name);
    Optional<TrainingCategory> findByName(String name);
}
