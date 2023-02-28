package bd.gov.plandiv.pdts.controller;




import bd.gov.plandiv.pdts.entity.Department;
import bd.gov.plandiv.pdts.entity.ForeignTourPurpose;
import bd.gov.plandiv.pdts.service.ForeignTourPurposeService;
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
@RequestMapping(value = "/foreign-tour-purpose/")
public class ForeignTourPurposeController {
    private final ForeignTourPurposeService service;

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("foreignTourPurposeAddClass","active");
        model.addAttribute("foreignTourPurpose",new ForeignTourPurpose());
        return "foreign-tour-purposes/add";
    }
    @PostMapping(value = "add")
    public String save(@Validated ForeignTourPurpose foreignTourPurpose, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(foreignTourPurpose.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.save(foreignTourPurpose);
                if (status) {
                    model.addAttribute("successMsg", "ForeignTourPurpose Saved Successfully");
                    model.addAttribute("department",new Department());
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        return "foreign-tour-purposes/add";
    }


    @GetMapping(value = "update/{id}")
    public String showUpdate(@PathVariable("id") Long id, Model model){
        model.addAttribute("foreignTourPurpose",this.service.findById(id));
        return "foreign-tour-purposes/edit";
    }
    @PostMapping(value = "update/{id}")
    public String update(@Validated ForeignTourPurpose foreignTourPurpose, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(foreignTourPurpose.getName()) && !service.findById(foreignTourPurpose.getId()).get().getName().equalsIgnoreCase(foreignTourPurpose.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.update(foreignTourPurpose);
                if (status) {
                    model.addAttribute("successMsg", "ForeignTourPurpose Updated Successfully");
                    model.addAttribute("department",this.service.findById(id));
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        return "foreign-tour-purposes/edit";
    }
    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("foreignTourPurposeListClass","active");
        model.addAttribute("list",service.findAll());
        return "foreign-tour-purposes/list";
    }


    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id){
        boolean status=this.service.delete(id);
        return "redirect:/foreign-tour-purpose/list";
    }

}
