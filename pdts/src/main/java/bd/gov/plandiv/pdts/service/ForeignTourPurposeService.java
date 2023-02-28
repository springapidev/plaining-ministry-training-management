package bd.gov.plandiv.pdts.service;



import bd.gov.plandiv.pdts.entity.ForeignTourPurpose;

import java.util.List;
import java.util.Optional;

public interface ForeignTourPurposeService {
    boolean save(ForeignTourPurpose foreignTourPurpose);
    boolean update(ForeignTourPurpose foreignTourPurpose);
    boolean isExistById(Long id);
    boolean isExistByName(String name);
    Optional<ForeignTourPurpose> findById(Long id);
    Optional<ForeignTourPurpose> findByName(String name);
    boolean delete(Long id);
    List<ForeignTourPurpose> findAll();


}
