package bd.gov.plandiv.pdts.repository;

import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.entity.ForeignTour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface ForeignTourRepository extends JpaRepository<ForeignTour, Long>  {
List<ForeignTour> findAllByEmployeeAndEndDateBetween(Employee employee, LocalDate startDate, LocalDate endDate);
List<ForeignTour> findAllByEndDateBetween(LocalDate startDate, LocalDate endDate);
}
