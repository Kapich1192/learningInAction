package com.learningInAction.controllers.account.profile;

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

@Controller
public class ProfileController {
    /*================================================= FIELDS =======================================================*/
    private String title = "Profile";
    @Autowired
    UserRepo userRepo;
    /*================================================= GET ==========================================================*/
    @GetMapping("/profile")
    public String getProfile(Model model) {
        model.addAttribute("title", title);
        Authentication auth =SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName());
        model.addAttribute("usr",user);
        return "pages/profile/profile";
    }
    /*================================================= POST =========================================================*/
    /*update name*/
    @PostMapping("/profile/upd_name")
    public String updateName(@RequestParam String upd_name) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName());
        user.setName(upd_name);
        userRepo.save(user);
        return "redirect:/profile";
    }
    /*update lastname*/
    @PostMapping("/profile/upd_lastname")
    public String updateLastname(@RequestParam String upd_lastname) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName());
        user.setLastname(upd_lastname);
        userRepo.save(user);
        return "redirect:/profile";
    }
    /*update tel*/
    @PostMapping("/profile/upd_tel")
    public String updateTel(@RequestParam String upd_tel) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName());
        user.setTel(upd_tel);
        userRepo.save(user);
        return "redirect:/profile";
    }
    /*update email*/
    @PostMapping("/profile/upd_email")
    public String updateEmail(@RequestParam String upd_email) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName());
        user.setEmail(upd_email);
        userRepo.save(user);
        return "redirect:/profile";
    }
}
