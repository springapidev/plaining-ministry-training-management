package bd.gov.plandiv.pdts.controller;



import bd.gov.plandiv.pdts.entity.Department;
import bd.gov.plandiv.pdts.entity.Designation;
import bd.gov.plandiv.pdts.service.DesignationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/designation/")
public class DesignationController {
    private final DesignationService service;

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("designationAddClass","active");
        model.addAttribute("designation",new Designation());
        return "designations/add";
    }
    @PostMapping(value = "add")
    public String save(@Validated Designation designation, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(designation.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.save(designation);
                if (status) {
                    model.addAttribute("successMsg", "Designation Saved Successfully");
                    model.addAttribute("designation",new Designation());
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        return "designations/add";
    }
    @GetMapping(value = "update/{id}")
    public String showUpdate(@PathVariable("id") Long id, Model model){
        model.addAttribute("designation",this.service.findById(id));
        return "designations/edit";
    }

    @PostMapping(value = "update/{id}")
    public String update(@Validated Designation designation, BindingResult result, @PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(designation.getName()) && !service.findById(designation.getId()).get().getName().equalsIgnoreCase(designation.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.update(designation);
                if (status) {
                    model.addAttribute("successMsg", "Designation Updated Successfully");
                    model.addAttribute("role",this.service.findById(id));
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        return "designations/edit";
    }
    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("list",service.findAll());
        model.addAttribute("designationListClass","active");
        return "designations/list";
    }


    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id){
        boolean status=this.service.delete(id);
        return "redirect:/designation/list";
    }
}
