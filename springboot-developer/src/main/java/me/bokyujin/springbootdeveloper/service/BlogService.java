package me.bokyujin.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.bokyujin.springbootdeveloper.domain.Article;
import me.bokyujin.springbootdeveloper.dto.AddArticleRequest;
import me.bokyujin.springbootdeveloper.dto.UpdateArticleRequest;
import me.bokyujin.springbootdeveloper.repository.BlogRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request, String userName){

        return blogRepository.save(request.toEntity(userName));
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));
    }

    public void delete(long id) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        authorizeArticleAuthor(article);
        blogRepository.delete(article);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        authorizeArticleAuthor(article);
        article.update(request.getTitle(), request.getContent()); // 빌더 패턴으로 객체 생성

        return article;
    }

    //게시글을 작성한 유저인지 확인
    private static void authorizeArticleAuthor(Article article){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if(!article.getAuthor().equals(userName)){
            throw new IllegalArgumentException("not authorized");
        }
    }

}
