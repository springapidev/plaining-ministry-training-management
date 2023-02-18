package bd.gov.plandiv.pdts.controller;




import bd.gov.plandiv.pdts.entity.Department;
import bd.gov.plandiv.pdts.service.DepartmentService;
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
@RequestMapping(value = "/department/")
public class DepartmentController {
    private final DepartmentService service;

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("departmentAddClass","active");
        model.addAttribute("department",new Department());
        return "departments/add";
    }
    @PostMapping(value = "add")
    public String save(@Validated Department department, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(department.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.save(department);
                if (status) {
                    model.addAttribute("successMsg", "Department Saved Successfully");
                    model.addAttribute("department",new Department());
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        return "departments/add";
    }


    @GetMapping(value = "update/{id}")
    public String showUpdate(@PathVariable("id") Long id, Model model){
        model.addAttribute("department",this.service.findById(id));
        return "departments/edit";
    }
    @PostMapping(value = "update/{id}")
    public String update(@Validated Department department, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(department.getName()) && !service.findById(department.getId()).get().getName().equalsIgnoreCase(department.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.update(department);
                if (status) {
                    model.addAttribute("successMsg", "Department Updated Successfully");
                    model.addAttribute("department",this.service.findById(id));
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        return "departments/edit";
    }
    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("departmentListClass","active");
        model.addAttribute("list",service.findAll());
        return "departments/list";
    }


    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id){
        boolean status=this.service.delete(id);
        return "redirect:/department/list";
    }

}
