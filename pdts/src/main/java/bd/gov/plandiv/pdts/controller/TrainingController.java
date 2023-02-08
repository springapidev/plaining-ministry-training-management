package bd.gov.plandiv.pdts.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/training/")
public class TrainingController {

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("trainingAddClass","active");
        return "trainings/add";
    }

    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("trainingListClass","active");
        return "trainings/list";
    }
}
