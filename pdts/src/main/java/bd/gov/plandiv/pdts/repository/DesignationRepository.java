package bd.gov.plandiv.pdts.repository;

import bd.gov.plandiv.pdts.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DesignationRepository extends JpaRepository<Designation, Long>  {
    Optional<Designation> findByName(String name);
    boolean existsByName(String name);
}
