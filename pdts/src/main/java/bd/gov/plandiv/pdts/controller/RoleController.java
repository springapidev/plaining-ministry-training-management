package bd.gov.plandiv.pdts.controller;

import bd.gov.plandiv.pdts.entity.Role;
import bd.gov.plandiv.pdts.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/role/")
public class RoleController {
    private final RoleService service;

    @GetMapping(value = "add")
    public String showSave(Model model){
        model.addAttribute("role",new Role());
        return "roles/add";
    }
    @PostMapping(value = "add")
    public String save(@Validated Role role, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(role.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.save(role);
                if (status) {
                    model.addAttribute("successMsg", "Role Saved Successfully");
                    model.addAttribute("role",new Role());
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        return "roles/add";
    }


    @GetMapping(value = "update/{id}")
    public String showUpdate(@PathVariable("id") Long id,Model model){
        model.addAttribute("role",this.service.findById(id));
        return "roles/edit";
    }
    @PostMapping(value = "update/{id}")
    public String update(@Validated Role role, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(role.getName()) && !service.findById(role.getId()).get().getName().equalsIgnoreCase(role.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.update(role);
                if (status) {
                    model.addAttribute("successMsg", "Role Updated Successfully");
                    model.addAttribute("role",this.service.findById(id));
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        return "roles/edit";
    }
    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("list",service.findAll());
        return "roles/list";
    }


    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id){
        boolean status=this.service.delete(id);
        return "redirect:/role/list";
    }

    @GetMapping(value = "search")
    public String search(@RequestParam(value = "name",defaultValue = "ADMIN") String name,Model model){
       model.addAttribute("rolelist",this.service.search(name));
        return "roles/list";
    }
}
