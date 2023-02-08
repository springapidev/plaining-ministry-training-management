package bd.gov.plandiv.pdts.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/employee/")
public class EmployeeController {

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("employeeAddClass","active");
        return "employees/add";
    }

    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("employeeListClass","active");
        return "employees/list";
    }
}
