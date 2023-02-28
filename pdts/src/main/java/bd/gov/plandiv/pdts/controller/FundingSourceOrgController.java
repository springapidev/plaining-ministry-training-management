package bd.gov.plandiv.pdts.controller;

import bd.gov.plandiv.pdts.entity.FundingSourceOrg;
import bd.gov.plandiv.pdts.service.FundingSourceOrgService;
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
@RequestMapping(value = "/funding-source-org/")
public class FundingSourceOrgController {

    private final FundingSourceOrgService service;

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("fundingSourceOrg",new FundingSourceOrg());
        model.addAttribute("fundingSourceOrgAddClass","active");
        return "funding-source-orgs/add";
    }
    @PostMapping(value = "add")
    public String save(@Validated FundingSourceOrg fundingSourceOrg, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(fundingSourceOrg.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.save(fundingSourceOrg);
                if (status) {
                    model.addAttribute("successMsg", "FundingSourceOrg Saved Successfully");
                    model.addAttribute("fundingSourceOrg",new FundingSourceOrg());
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        return "funding-source-orgs/add";
    }

    @GetMapping(value = "update/{id}")
    public String showUpdate(@PathVariable("id") Long id, Model model){
        model.addAttribute("fundingSourceOrg",this.service.findById(id));
        return "funding-source-orgs/edit";
    }
    @PostMapping(value = "update/{id}")
    public String update(@Validated FundingSourceOrg fundingSourceOrg, BindingResult result,@PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }else {
            if(service.isExistByName(fundingSourceOrg.getName()) && !service.findById(fundingSourceOrg.getId()).get().getName().equalsIgnoreCase(fundingSourceOrg.getName())){
                model.addAttribute("errMsg","Name is already exist!");
            }else {
                boolean status = service.update(fundingSourceOrg);
                if (status) {
                    model.addAttribute("successMsg", "fundingSourceOrg Updated Successfully");
                    model.addAttribute("fundingSourceOrg",this.service.findById(id));
                }else {
                    model.addAttribute("errMsg","Something is wrong");
                }
            }
        }

        return "funding-source-orgs/edit";
    }
    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id){
        boolean status=this.service.delete(id);
        return "redirect:/funding-source-org/list";
    }
    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("fundingSourceOrgListClass","active");
        model.addAttribute("list",this.service.findAll());
        return "funding-source-orgs/list";
    }
}
