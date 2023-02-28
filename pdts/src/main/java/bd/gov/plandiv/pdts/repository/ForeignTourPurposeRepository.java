package bd.gov.plandiv.pdts.repository;

import bd.gov.plandiv.pdts.entity.ForeignTourPurpose;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ForeignTourPurposeRepository extends JpaRepository<ForeignTourPurpose,Long> {
    boolean existsByName(String name);
    Optional<ForeignTourPurpose> findByName(String name);
}
