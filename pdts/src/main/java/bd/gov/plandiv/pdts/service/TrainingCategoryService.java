package bd.gov.plandiv.pdts.service;

import bd.gov.plandiv.pdts.entity.TrainingCategory;

import java.util.List;
import java.util.Optional;

public interface TrainingCategoryService {
    boolean save(TrainingCategory trainingCategory);
    boolean update(TrainingCategory trainingCategory);
    boolean isExistById(Long id);
    boolean isExistByName(String name);
    Optional<TrainingCategory> findById(Long id);
    Optional<TrainingCategory> findByName(String name);
    boolean delete(Long id);
    List<TrainingCategory> findAll();
}
