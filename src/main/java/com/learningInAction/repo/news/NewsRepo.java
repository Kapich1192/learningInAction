package com.learningInAction.repo.news;

import com.learningInAction.model.news.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepo extends JpaRepository<News, Long> {
}
