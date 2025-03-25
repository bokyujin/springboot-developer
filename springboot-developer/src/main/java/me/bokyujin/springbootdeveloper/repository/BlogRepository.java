package me.bokyujin.springbootdeveloper.repository;

import me.bokyujin.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
