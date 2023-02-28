package bd.gov.plandiv.pdts.repository;


import bd.gov.plandiv.pdts.entity.FundingSourceOrg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FundingSourceOrgRepository extends JpaRepository<FundingSourceOrg, Long>  {
    boolean existsByName(String name);
    Optional<FundingSourceOrg> findByName(String name);
}
