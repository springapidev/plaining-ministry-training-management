package bd.gov.plandiv.pdts.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/designation/")
public class DesignationController {

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("designationAddClass","active");
        return "designations/add";
    }

    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("designationListClass","active");
        return "designations/list";
    }
}
