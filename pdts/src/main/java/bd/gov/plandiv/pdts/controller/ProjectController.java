package bd.gov.plandiv.pdts.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/project/")
public class ProjectController {

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("projectAddClass","active");
        return "projects/add";
    }

    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("projectListClass","active");
        return "projects/list";
    }
}
