package bd.gov.plandiv.pdts.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/funding-source-org/")
public class FundingSourceOrgController {

    @GetMapping(value = "add")
    public String showAdd(Model model){
        model.addAttribute("fundingSourceOrgAddClass","active");
        return "funding-source-orgs/add";
    }

    @GetMapping(value = "list")
    public String showList(Model model){
        model.addAttribute("fundingSourceOrgListClass","active");
        return "funding-source-orgs/list";
    }
}
