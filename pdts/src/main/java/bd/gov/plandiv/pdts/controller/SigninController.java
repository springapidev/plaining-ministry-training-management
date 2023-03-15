package bd.gov.plandiv.pdts.controller;



import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SigninController {

    @GetMapping(value = "/signin")
    public String showSignin(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            return "redirect:/";
        }
        return "signin";// Here signin is page name signin.html
    }

    @GetMapping(value = "/forgot-password")
    public String showForgotPassword(){
        return "forgot-password";
    }
}
