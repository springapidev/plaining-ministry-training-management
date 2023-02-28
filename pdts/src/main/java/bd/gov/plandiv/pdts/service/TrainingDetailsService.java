package bd.gov.plandiv.pdts.service;

import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.entity.Training;
import bd.gov.plandiv.pdts.entity.TrainingDetails;

import java.util.List;
import java.util.Optional;

public interface TrainingDetailsService {
    boolean save(TrainingDetails trainingDetails);
    boolean update(TrainingDetails trainingDetails);
    boolean isExistById(Long id);
    Optional<TrainingDetails> findById(Long id);
    boolean delete(Long id);
    List<TrainingDetails> findAll();
    List<TrainingDetails> findAllByEmplyee(Employee employee);
    List<TrainingDetails> findAllByTraining(Training training);


}
