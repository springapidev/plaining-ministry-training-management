package bd.gov.plandiv.pdts.controller;


import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.service.DepartmentService;
import bd.gov.plandiv.pdts.service.DesignationService;
import bd.gov.plandiv.pdts.service.EmployeeService;
import bd.gov.plandiv.pdts.service.RoleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/employee/")
@AllArgsConstructor
public class EmployeeController {


    private final EmployeeService service;
    private final RoleService roleService;
    private final DepartmentService departmentService;
    private final DesignationService designationService;

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("employeeAddClass","active");
        model.addAttribute("roleList",this.roleService.findAll());
        model.addAttribute("departmentList",this.departmentService.findAll());
        model.addAttribute("designationList",this.designationService.findAll());
        return "employees/add";
    }
    @PostMapping(value = "add")
    public String save(@Valid Employee employee, BindingResult result, Model model){
        System.out.println(employee);
        if(result.hasFieldErrors()){
            model.addAttribute("errMsg","Please Fix all the errors!");
            model.addAttribute("roleList",this.roleService.findAll());
            model.addAttribute("departmentList",this.departmentService.findAll());
            model.addAttribute("designationList",this.designationService.findAll());
            return "employees/add";
        }else {
            if(service.isExistByEmail(employee.getEmail())){
                model.addAttribute("errMsg","Email is already exist!");
            }else {
                boolean status = service.save(employee);
                if (status) {
                    model.addAttribute("successMsg", "Employee Saved Successfully");
                    model.addAttribute("employee",new Employee());

                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        model.addAttribute("roleList",this.roleService.findAll());
        model.addAttribute("departmentList",this.departmentService.findAll());
        model.addAttribute("designationList",this.designationService.findAll());

        return "employees/add";
    }
    @GetMapping(value = "view/{id}")
    public String showUpdate(@PathVariable("id") Long id, Model model){
        model.addAttribute("employee",this.service.findById(id));
        return "employees/view";
    }
    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("employeeListClass","active");
        model.addAttribute("list",this.service.findAll());
        return "employees/list";
    }
}
