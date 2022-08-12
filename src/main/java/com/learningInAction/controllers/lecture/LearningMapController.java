package com.learningInAction.controllers.lecture;

import com.learningInAction.model.user.User;
import com.learningInAction.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LearningMapController {
    /*================================================= FIELDS =======================================================*/
    @Autowired
    UserRepo userRepo;
    /*================================================= GET ==========================================================*/
    @GetMapping("/learning_map")
    public String getLearningMap(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName());
        model.addAttribute("usr",user);

        return "pages/lecture/learning_map";
    }
    /*================================================= POST =========================================================*/
    /*================================================= UPDATE =======================================================*/
    /*================================================= DELETE =======================================================*/
}
