package bd.gov.plandiv.pdts.service;

import bd.gov.plandiv.pdts.entity.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingService {
    boolean save(Training training);
    boolean update(Training training);
    boolean isExistById(Long id);
    boolean isExistByName(String name);
    Optional<Training> findById(Long id);
    Optional<Training> findByName(String name);
    boolean delete(Long id);
    List<Training> findAll();


}
