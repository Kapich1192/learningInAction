package com.learningInAction.controllers.login.home;

import com.learningInAction.model.user.Role;
import com.learningInAction.model.user.User;
import com.learningInAction.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

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
    public String postReg(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "pages/login/registration";
        }
        user.setActive(true);
        user.setRole(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/dashboard";
    }
}
