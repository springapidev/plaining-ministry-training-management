package bd.gov.plandiv.pdts.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SigninController {

    @GetMapping(value = "/signin")
    public String showSignin(){
        return "signin";// Here signin is page name signin.html
    }

    @GetMapping(value = "/forgot-password")
    public String showForgotPassword(){
        return "forgot-password";
    }
}
