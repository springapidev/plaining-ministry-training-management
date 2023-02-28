package bd.gov.plandiv.pdts.controller;

import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.entity.Training;
import bd.gov.plandiv.pdts.service.EmployeeService;
import bd.gov.plandiv.pdts.service.ForeignTourService;
import bd.gov.plandiv.pdts.service.TrainingDetailsService;
import bd.gov.plandiv.pdts.service.TrainingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/report/")
public class ReportController {
    private final TrainingService trainingService;
    private final TrainingDetailsService trainingDetailsService;
    private final EmployeeService employeeService;
    private final ForeignTourService foreignTourService;

    /**

     * Which employees have done specific training
     *
     * Training List according to specific project
     *  * Which employees have gone to foreign within a date range
     *   List of an employee within a date range
     *
     */

    @GetMapping(value = "training-list-by-employee")
    public String trainingListByEmployee(@RequestParam(name = "email",required = false) String email,
                           @RequestParam(name = "mobile",required = false) String mobile,
                           @RequestParam(name = "idNo",required = false) String idNo,
                           Model model) {
        Employee employee=this.employeeService.findByEmailOrMobileOrIdNoContaining(email,mobile,idNo);
        model.addAttribute("trainingList", trainingDetailsService.findAllByEmplyee(employee));
        return "reports/training-list-by-employee";
    }

    @GetMapping(value = "employee-list-by-training")
    public String employeeListByTraining(@RequestParam(name = "name",required = false) String name,
                           Model model) {
        Optional<Training> training=this.trainingService.findByName(name);
        if(training.isPresent()) {
            model.addAttribute("employeeList", trainingDetailsService.findAllByTraining(training.get()));
        }
        return "reports/training-list-by-employee";
    }

    @GetMapping(value = "foreign-tour-employee-list-by-date-range")
    public String employeeListforForeignTourByDateRanges(@RequestParam(name = "email",required = false) String email,
                                                         @RequestParam(name = "mobile",required = false) String mobile,
                                                         @RequestParam(name = "idNo",required = false) String idNo,
                                                         @RequestParam(name = "startDate",required = false) LocalDate startDate,
                                                         @RequestParam(name = "endDate",required = false)  LocalDate endDate,
                                         Model model) {
        Employee employee=this.employeeService.findByEmailOrMobileOrIdNoContaining(email,mobile,idNo);

            model.addAttribute("employeeForeignTourListBydateRanges", foreignTourService.findAllByEmployeeAndEndDateBetween(employee,startDate,endDate));

        return "reports/foreign-tour-list-by-employee";
    }
    @GetMapping(value = "foreign-tour-employee-list")
    public String employeeListforForeignTour(@RequestParam(name = "startDate",required = false) LocalDate startDate,
                                                         @RequestParam(name = "endDate",required = false)  LocalDate endDate,
                                                         Model model) {


        model.addAttribute("employeeForeignTourList", foreignTourService.findAllByEndDateBetween(startDate,endDate));

        return "reports/foreign-tour-list";
    }
}
