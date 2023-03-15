package bd.gov.plandiv.pdts.controller;

import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.repository.EmployeeRepository;
import bd.gov.plandiv.pdts.service.EmployeeService;
import bd.gov.plandiv.pdts.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ProfileController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/gif");
    @Value("${extern.resoures.path}")
    private String path;
    @Value("${extern.resources.Dir}")
    private String resourceDir;

    @GetMapping(value = "/profile")
    public String showProfile(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.isAuthenticated()) {
            System.out.printf("Auth=> " + auth.getName());
            Employee employee = employeeService.findByEmail(auth.getName()).get();
            model.addAttribute("profile", employee);
        }
        return "users/page-user-profile";
    }

    @PostMapping(value = "/change-photo")
    public String changePhoto(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            String fileContentType = file.getContentType();
            if (!file.isEmpty() && contentTypes.contains(fileContentType)) {
                Optional<Employee> loggedInuser=this.employeeService.findByEmail(auth.getName());
                String photoUrl ="/"+ resourceDir +"/"+loggedInuser.get().getId()+"/" + StringUtils.cleanPath(file.getOriginalFilename());
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                //String uploadDir = "profile-photo/" + loggedInuser.get().getId();
                String uploadDir =path+ String.valueOf(loggedInuser.get().getId());
             //   String uploadDir ="/home/profile-photo/"+ String.valueOf(loggedInuser.get().getId());
                FileUploadUtil.saveFile(uploadDir, fileName, file);
                this.employeeRepository.changePhoto(photoUrl,auth.getName());
            }

        } catch (Exception e) {
            return "users/page-user-profile";
        }
        model.addAttribute("profile",employeeService.findByEmail(auth.getName()).get());
        return "redirect:/profile";
    }
    @PostMapping(value = "/change-password")
    public String changePassword(@RequestParam("passwordOld") String passwordOld, @RequestParam("passwordNew") String passwordNew,Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee user = this.employeeService.findByEmail(auth.getName()).get();
        try {
          if(passwordEncoder.matches(passwordOld,user.getPassword()) && isValidPassword(passwordNew)){
              this.employeeRepository.updatePassword(passwordEncoder.encode(passwordNew),auth.getName());
              model.addAttribute("passchangeSuc","Success!");
          }else {
              model.addAttribute("errMsg","Check Password Pattern");
          }

        } catch (Exception e) {
            model.addAttribute("errMsg","Check Password Pattern");
            return "users/page-user-profile";
        }
        model.addAttribute("profile",employeeService.findByEmail(auth.getName()).get());
        return "redirect:/profile";
    }
    private boolean isValidPassword(String password){
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    @PostMapping(value = "/change-info")
    public String changeInfo(@RequestParam("fullName") String fullName,
                             @RequestParam("biography") String biography,
                             @RequestParam("birthDate") String birthDate,
                             @RequestParam("mobile") String mobile,
                             Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            int status = this.employeeRepository.updateUserInfo(fullName,biography,LocalDate.parse(birthDate,DateTimeFormatter.ofPattern("yyyy-MM-dd")),mobile,auth.getName());
            if(status > 0){
                model.addAttribute("successInfoMsg","Your Info Updated success");
            }else {
                model.addAttribute("errInfoMsg","Check Password Pattern");
            }

        } catch (Exception e) {
            model.addAttribute("errMsg","Check Password Pattern");
            return "users/page-user-profile";
        }
        model.addAttribute("profile",employeeService.findByEmail(auth.getName()).get());
        return "redirect:/profile";
    }
}
