package com.hui.blog.service;

import com.hui.blog.domain.Article;
import com.hui.blog.dto.AddArticleRequest;
import com.hui.blog.dto.UpdateArticleRequest;
import com.hui.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // final 이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());

    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional // 트랜잭션 메서드 
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Not Found: "+ id));

        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
