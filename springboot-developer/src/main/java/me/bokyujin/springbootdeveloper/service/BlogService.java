package me.bokyujin.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.bokyujin.springbootdeveloper.domain.Article;
import me.bokyujin.springbootdeveloper.dto.AddArticleRequest;
import me.bokyujin.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}
