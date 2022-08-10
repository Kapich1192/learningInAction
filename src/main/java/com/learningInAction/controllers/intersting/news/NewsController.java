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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

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
    /*get single news*/
    @GetMapping("/news/{id}")
    public String getSingleNews(@PathVariable(value = "id") Long id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName());
        model.addAttribute("usr", user);

        Optional<News> news = newsRepo.findById(id);

       ArrayList<News> res = new ArrayList<>();
       news.ifPresent(res::add);
       News single_news = res.get(0);

        model.addAttribute("news", single_news);
        return "pages/news/single_news";
    }
    /*add news*/
    @GetMapping("/admin/add_news")
    public String getAddNews(Model model) {
        model.addAttribute("title","Add News");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName());
        model.addAttribute("usr",user);

        Iterable<News> all_news = newsRepo.findAll();
        model.addAttribute("news",all_news);
        return "pages/news/add_news";
    }
    @GetMapping("admin/update_news_{id}")
    public String getUpdateNews(@PathVariable(value = "id") Long id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName());
        model.addAttribute("usr", user);

        Optional<News> news = newsRepo.findById(id);
        ArrayList<News> res = new ArrayList<>();
        news.ifPresent(res::add);
        News single_news = res.get(0);
        model.addAttribute("news", single_news);
        return "pages/news/update_news";
    }
    /*================================================= POST =========================================================*/
    @PostMapping("/admin/add_news")
    public String postAddNews(@RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String tag,
                              @RequestParam String body_news) throws Exception{
        News news = new News();
        news.setTitle(title);
        news.setAnons(anons);
        news.setBodyNews(tag);
        news.setBody(body_news);
        newsRepo.save(news);
        return "redirect:/admin/add_news";
    }
    /*================================================= UPDATE =======================================================*/
    @PostMapping("/admin/update_news_{id}")
    public String updateNews(@PathVariable(value = "id") Long id,
                             @RequestParam String body_news,
                             @RequestParam String title,
                             @RequestParam String anons) {
        Optional<News> news = newsRepo.findById(id);
        ArrayList<News> res = new ArrayList<>();
        news.ifPresent(res :: add);
        News thisNews = res.get(0);
        thisNews.setBody(body_news);
        thisNews.setTitle(title);
        thisNews.setAnons(anons);
        newsRepo.save(thisNews);
        return "redirect:/admin/update_news_{id}";
    }
}
