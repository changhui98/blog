package com.hui.blog.dto;

import com.hui.blog.domain.Article;
import lombok.Getter;

@Getter
public class ArticleResponse {

    private final String title;

    private final String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
