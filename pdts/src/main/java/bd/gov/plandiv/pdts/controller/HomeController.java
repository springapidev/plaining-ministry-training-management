package bd.gov.plandiv.pdts.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String showHome(){
        return "dashboard";
    }

    @GetMapping(value = "/test")
    public String showTest(){
        return "test";
    }
}
