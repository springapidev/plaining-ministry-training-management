package bd.gov.plandiv.pdts.controller;

import bd.gov.plandiv.pdts.entity.Training;
import bd.gov.plandiv.pdts.service.ProjectService;
import bd.gov.plandiv.pdts.service.TrainingCategoryService;
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
@RequestMapping(value = "/training/")
public class TrainingController {
    private final TrainingService service;
    private final ProjectService projectService;
    private final TrainingCategoryService categoryService;

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("trainingAddClass","active");
        model.addAttribute("training",new Training());
        model.addAttribute("projects",this.projectService.findAll());
        model.addAttribute("trainingCategories",this.categoryService.findAll());
        return "trainings/add";
    }
    @PostMapping(value = "add")
    public String save(@Validated Training training, BindingResult result, Model model){
        System.out.printf("Ok");
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(training.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.save(training);
                if (status) {
                    model.addAttribute("successMsg", "Training Saved Successfully");
                    model.addAttribute("training",new Training());
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }
        model.addAttribute("projects",this.projectService.findAll());
        model.addAttribute("trainingCategories",this.categoryService.findAll());
        return "trainings/add";
    }


    @GetMapping(value = "update/{id}")
    public String showUpdate(@PathVariable("id") Long id, Model model){
        model.addAttribute("training",this.service.findById(id));
        model.addAttribute("projects",this.projectService.findAll());
        return "trainings/edit";
    }
    @PostMapping(value = "update/{id}")
    public String update(@Validated Training training, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(training.getName()) && !service.findById(training.getId()).get().getName().equalsIgnoreCase(training.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.update(training);
                if (status) {
                    model.addAttribute("successMsg", "Training Updated Successfully");
                    model.addAttribute("training",this.service.findById(id));
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }
        model.addAttribute("projects",this.projectService.findAll());
        model.addAttribute("trainingCategories",this.categoryService.findAll());
        return "trainings/edit";
    }

    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id){
        boolean status=this.service.delete(id);
        return "redirect:/training/list";
    }
    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("trainingListClass","active");
        model.addAttribute("list",service.findAll());
        return "trainings/list";
    }
}
