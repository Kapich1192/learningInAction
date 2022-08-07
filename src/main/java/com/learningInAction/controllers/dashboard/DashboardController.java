package com.learningInAction.controllers.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    /*================================================= FIELDS =======================================================*/
    private String title = "Dashboard";
    /*================================================= GET ==========================================================*/
    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("title", title);
        return "pages/dashboard/dashboard";
    }
    /*================================================= POST =========================================================*/
}
