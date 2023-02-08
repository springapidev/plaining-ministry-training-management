package bd.gov.plandiv.pdts.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/training-category/")
public class TrainingCategoryController {

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("trainingCategoryAddClass","active");
        return "training-categories/add";
    }

    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("trainingCategoryListClass","active");
        return "training-categories/list";
    }
}
