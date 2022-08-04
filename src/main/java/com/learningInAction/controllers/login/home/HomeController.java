package com.learningInAction.controllers.login.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    /*================================================= FIELDS =======================================================*/
    private String pageTemplate = "pages/login/home";
    /*================================================= GET ==========================================================*/
    @GetMapping("/")
    public String getHome(Model model) {
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
        model.addAttribute("mes","Registration on locking");
        return "redirect:/";
    }
}