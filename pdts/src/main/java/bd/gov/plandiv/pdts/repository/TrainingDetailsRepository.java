package bd.gov.plandiv.pdts.repository;


import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.entity.Training;
import bd.gov.plandiv.pdts.entity.TrainingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainingDetailsRepository extends JpaRepository<TrainingDetails, Long>  {
    Optional<TrainingDetails> findByEmployeeAndTraining(Employee employee, Training training);
    List<TrainingDetails> findAllByEmployee(Employee employee);
    List<TrainingDetails> findAllByTraining(Training training);
}
