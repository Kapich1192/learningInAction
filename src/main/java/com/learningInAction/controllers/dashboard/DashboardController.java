package com.learningInAction.controllers.dashboard;

import com.learningInAction.model.user.User;
import com.learningInAction.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    /*================================================= FIELDS =======================================================*/
    private String title = "Dashboard";
    @Autowired
    UserRepo userRepo;
    /*================================================= GET ==========================================================*/
    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        /*+++++ Meta +++++*/
        model.addAttribute("title", title);
        /*+++++ User +++++*/
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName());
        model.addAttribute("usr",user);
        return "pages/dashboard/dashboard";
    }
    /*================================================= POST =========================================================*/
}
