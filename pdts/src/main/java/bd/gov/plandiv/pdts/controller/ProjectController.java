package bd.gov.plandiv.pdts.controller;



import bd.gov.plandiv.pdts.entity.Project;
import bd.gov.plandiv.pdts.service.FundingSourceOrgService;
import bd.gov.plandiv.pdts.service.ProjectService;
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
@RequestMapping(value = "/project/")
public class ProjectController {
    private final ProjectService service;
    private final FundingSourceOrgService fundingSourceOrgService;

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("projectAddClass","active");
        model.addAttribute("project",new Project());
        model.addAttribute("fundingsources",fundingSourceOrgService.findAll());
        return "projects/add";
    }
    @PostMapping(value = "add")
    public String save(@Validated Project project, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(project.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.save(project);
                if (status) {
                    model.addAttribute("successMsg", "Project Saved Successfully");
                    model.addAttribute("project",new Project());

                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        model.addAttribute("fundingsources",fundingSourceOrgService.findAll());
        return "projects/add";
    }


    @GetMapping(value = "update/{id}")
    public String showUpdate(@PathVariable("id") Long id, Model model){
        model.addAttribute("project",this.service.findById(id));
        model.addAttribute("fundingsources",fundingSourceOrgService.findAll());
        return "projects/edit";
    }
    @PostMapping(value = "update/{id}")
    public String update(@Validated Project project, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(project.getName()) && !service.findById(project.getId()).get().getName().equalsIgnoreCase(project.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.update(project);
                if (status) {
                    model.addAttribute("successMsg", "Project Updated Successfully");
                    model.addAttribute("project",this.service.findById(id));
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        model.addAttribute("fundingsources",fundingSourceOrgService.findAll());
        return "projects/edit";
    }

    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id){
        boolean status=this.service.delete(id);
        return "redirect:/project/list";
    }
    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("projectListClass","active");
        model.addAttribute("list",service.findAll());
        return "projects/list";
    }
}
