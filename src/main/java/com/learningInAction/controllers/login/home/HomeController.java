package com.learningInAction.controllers.login.home;

import com.learningInAction.model.user.User;
import com.learningInAction.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    /*================================================= FIELDS =======================================================*/
    private String pageTemplate = "pages/login/home";
    private String title = "School21 online";
    @Autowired
    UserRepo userRepo;
    /*================================================= GET ==========================================================*/
    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("title",title);
        return pageTemplate;
    }
    /*================================================= POST =========================================================*/
    @PostMapping("/")
    public String postReg(@RequestParam String login,
                          @RequestParam String password,
                          @RequestParam String name,
                          @RequestParam String lastname,
                          @RequestParam String tel,
                          @RequestParam String email,
                          Model model) {
        System.out.println(login);
        System.out.println(password);
        System.out.println(name);
        System.out.println(lastname);
        System.out.println(tel);
        System.out.println(email);
        User regUser = new User(login,password,name,lastname,tel,email);
        userRepo.save(regUser);
        return "redirect:/";
    }
}
