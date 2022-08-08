package com.learningInAction.controllers.intersting.news;

import com.learningInAction.model.news.News;
import com.learningInAction.model.user.User;
import com.learningInAction.repo.news.NewsRepo;
import com.learningInAction.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {
    /*================================================= FIELDS =======================================================*/
    private String title = "News";
    @Autowired
    UserRepo userRepo;
    @Autowired
    NewsRepo newsRepo;
    /*================================================= GET ==========================================================*/
    /*get all news*/
    @GetMapping("/news")
    public String getNews(Model model) {
        model.addAttribute("title", title);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName());
        model.addAttribute("usr", user);
        Iterable<News> news = newsRepo.findAll();
        model.addAttribute("news", news);
        return "pages/news/news";
    }
    /*================================================= POST =========================================================*/
}
