package com.learningInAction.controllers.admin;

import com.learningInAction.model.user.Role;
import com.learningInAction.model.user.User;
import com.learningInAction.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class AdminController {
    /*================================================= FIELDS =======================================================*/
    private String title = "Admin Panel";
    @Autowired
    UserRepo userRepo;
    /*================================================= GET ==========================================================*/
    /*Admin Panel*/
    @GetMapping("/admin")
    public String getAdminPanel(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName());
        model.addAttribute("usr",user);
        return "pages/admin/admin";
    }
    /*================================================= POST =========================================================*/
    @PostMapping("/admin")
    public String postAddNewUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "redirect:/admin";
        }
        user.setActive(true);
        user.setRole(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/admin";
    }
}
