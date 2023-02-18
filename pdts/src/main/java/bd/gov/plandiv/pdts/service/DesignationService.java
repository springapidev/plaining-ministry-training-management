package bd.gov.plandiv.pdts.service;

import bd.gov.plandiv.pdts.entity.Designation;

import java.util.List;
import java.util.Optional;

public interface DesignationService {
    boolean save(Designation designation);
    boolean update(Designation designation);
    boolean isExistById(Long id);
    boolean isExistByName(String name);
    Optional<Designation> findById(Long id);
    Optional<Designation> findByName(String name);
    boolean delete(Long id);
    List<Designation> findAll();

}
