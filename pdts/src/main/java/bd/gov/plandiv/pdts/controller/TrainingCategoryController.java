package bd.gov.plandiv.pdts.controller;

import bd.gov.plandiv.pdts.entity.TrainingCategory;
import bd.gov.plandiv.pdts.service.TrainingCategoryService;
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
@RequestMapping(value = "/training-category/")
public class TrainingCategoryController {
    private final TrainingCategoryService service;

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("trainingCategoryAddClass","active");
        model.addAttribute("trainingCategory",new TrainingCategory());
        return "training-categories/add";
    }
    @PostMapping(value = "add")
    public String save(@Validated TrainingCategory trainingCategory, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(trainingCategory.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.save(trainingCategory);
                if (status) {
                    model.addAttribute("successMsg", "TrainingCategory Saved Successfully");
                    model.addAttribute("trainingCategory",new TrainingCategory());
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        return "training-categories/add";
    }
    @GetMapping(value = "update/{id}")
    public String showUpdate(@PathVariable("id") Long id, Model model){
        model.addAttribute("trainingCategory",this.service.findById(id));
        return "training-categories/edit";
    }

    @PostMapping(value = "update/{id}")
    public String update(@Validated TrainingCategory trainingCategory, BindingResult result, @PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(trainingCategory.getName()) && !service.findById(trainingCategory.getId()).get().getName().equalsIgnoreCase(trainingCategory.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.update(trainingCategory);
                if (status) {
                    model.addAttribute("successMsg", "TrainingCategory Updated Successfully");
                    model.addAttribute("trainingCategory",this.service.findById(id));
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        return "training-categories/edit";
    }

    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id){
        boolean status=this.service.delete(id);
        return "redirect:/training-category/list";
    }

    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("trainingCategoryListClass","active");
        model.addAttribute("list",service.findAll());
        return "training-categories/list";
    }
}
