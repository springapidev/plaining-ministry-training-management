package bd.gov.plandiv.pdts.service;

import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.entity.ForeignTour;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ForeignTourService {
    boolean save(ForeignTour foreignTour);
    boolean update(ForeignTour foreignTour);
    boolean isExistById(Long id);
    Optional<ForeignTour> findById(Long id);
    boolean delete(Long id);
    List<ForeignTour> findAll();
    List<ForeignTour> findAllByEmployeeAndEndDateBetween(Employee employee, LocalDate startDate, LocalDate endDate);
    List<ForeignTour> findAllByEndDateBetween(LocalDate startDate, LocalDate endDate);

}
