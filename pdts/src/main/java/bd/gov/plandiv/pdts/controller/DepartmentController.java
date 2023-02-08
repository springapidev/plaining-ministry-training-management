package bd.gov.plandiv.pdts.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/department/")
public class DepartmentController {

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("departmentAddClass","active");
        return "departments/add";
    }

    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("departmentListClass","active");
        return "departments/list";
    }
}
