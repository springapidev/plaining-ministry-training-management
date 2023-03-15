package bd.gov.plandiv.pdts.utils;


import bd.gov.plandiv.pdts.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
@Slf4j
@ControllerAdvice
public class MvcAdvice {
    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute("photoUrl")
    public String showProfilePhoto() {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String url=null;
        try{
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth instanceof AnonymousAuthenticationToken)) {
                /* The user is logged in :) */
                url= employeeService.findByEmail(authentication.getName()).get().getPhoto();
            }
        }catch (Exception ne){
            log.error("MVC ADVICE Photo url not Found!");
        }
        return url;
    }
    @ModelAttribute("fullname")
    public String showlastName() {
        String fullname=null;
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        try{
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth instanceof AnonymousAuthenticationToken)) {
                /* The user is logged in :) */
                fullname= employeeService.findByEmail(authentication.getName()).get().getFirstName();
            }
        }catch (Exception ne){
            log.error("MVC ADVICE FullName url not Found!");
        }
        return fullname;
    }
}