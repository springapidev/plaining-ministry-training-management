package bd.gov.plandiv.pdts.controller;


import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.entity.ForeignTour;
import bd.gov.plandiv.pdts.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/foreign-tour/")
@AllArgsConstructor
public class ForeignTourController {


    private final DepartmentService departmentService;
    private final EmployeeService employeeService;
    private final ForeignTourPurposeService foreignTourPurposeService;
    private final ForeignTourService service;
    private final FundingSourceOrgService fundingSourceOrgService;


    @GetMapping(value = "add")
    public String showAdd(Model model) {
        model.addAttribute("foreignTourAddClass", "active");
        model.addAttribute("foreignTour", new ForeignTour());
        model.addAttribute("departmentList", this.departmentService.findAll());
        model.addAttribute("purposeList", this.foreignTourPurposeService.findAll());
        model.addAttribute("fundingSourceOrgList", this.fundingSourceOrgService.findAll());
        return "foreign-tours/add";
    }

    @PostMapping(value = "add")
    public String save(@Validated ForeignTour foreignTour, BindingResult result, Model model) {
        System.out.println(foreignTour);
        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Something is wrong");
        } else {

            boolean status = service.save(foreignTour);
            if (status) {
                model.addAttribute("successMsg", "ForeignTour Saved Successfully");
            } else {
                model.addAttribute("errMsg", "Something is wrong");
            }
        }

        model.addAttribute("foreignTour", new ForeignTour());
        model.addAttribute("departmentList", this.departmentService.findAll());
        model.addAttribute("purposeList", this.foreignTourPurposeService.findAll());
        model.addAttribute("fundingSourceOrgList", this.fundingSourceOrgService.findAll());
        return "foreign-tours/add";
    }

    @GetMapping(value = "view/{id}")
    public String showUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("foreignTour", this.service.findById(id));
        return "foreign-tours/view";
    }

    @GetMapping(value = "list")
    public String showList(Model model) {
        model.addAttribute("foreignTourListClass", "active");
        model.addAttribute("list", this.service.findAll());
        return "foreign-tours/list";
    }

    @ResponseBody
    @GetMapping(value = "api")
    public List<Employee> listByDepartment(@RequestParam("id") Long id){
        System.out.println("departmentId=> "+id);
        return this.employeeService.findAllByDepartment(this.departmentService.findById(id).get());
    }
}
