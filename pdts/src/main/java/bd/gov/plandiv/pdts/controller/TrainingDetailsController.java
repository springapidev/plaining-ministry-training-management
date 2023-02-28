package bd.gov.plandiv.pdts.controller;




import bd.gov.plandiv.pdts.entity.Department;
import bd.gov.plandiv.pdts.entity.TrainingDetails;
import bd.gov.plandiv.pdts.service.DepartmentService;
import bd.gov.plandiv.pdts.service.EmployeeService;
import bd.gov.plandiv.pdts.service.TrainingDetailsService;
import bd.gov.plandiv.pdts.service.TrainingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/training-details/")
public class TrainingDetailsController {
    private final TrainingDetailsService service;
    private final EmployeeService employeeService;
    private final TrainingService trainingService;

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("trainingDetailsAddClass","active");
        model.addAttribute("trainingDetails",new TrainingDetails());
        model.addAttribute("employees",this.employeeService.findAll());
        model.addAttribute("trainings",this.trainingService.findAll());
        return "training-details/add";
    }
    @PostMapping(value = "add")
    public String save(@Validated TrainingDetails trainingDetails, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {

                boolean status = service.save(trainingDetails);
                if (status) {
                    model.addAttribute("successMsg", "TrainingDetails Saved Successfully");
                    model.addAttribute("trainingDetails",new TrainingDetails());
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        model.addAttribute("employees",this.employeeService.findAll());
        model.addAttribute("trainings",this.trainingService.findAll());

        return "training-details/add";
    }



    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("trainingDetailsListClass","active");
        model.addAttribute("list",service.findAll());
        return "training-details/list";
    }


    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id){
        boolean status=this.service.delete(id);
        return "redirect:/training-details/list";
    }

}
