package bd.gov.plandiv.pdts.service;


import bd.gov.plandiv.pdts.entity.FundingSourceOrg;

import java.util.List;
import java.util.Optional;

public interface FundingSourceOrgService {
    boolean save(FundingSourceOrg fundingSourceOrg);
    boolean update(FundingSourceOrg fundingSourceOrg);
    boolean isExistById(Long id);
    boolean isExistByName(String name);
    Optional<FundingSourceOrg> findById(Long id);
    Optional<FundingSourceOrg> findByName(String name);
    boolean delete(Long id);
    List<FundingSourceOrg> findAll();


}
