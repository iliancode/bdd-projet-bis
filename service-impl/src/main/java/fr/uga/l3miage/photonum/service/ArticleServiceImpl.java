package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Article article = get(id);
        if (article == null) {
            throw new EntityNotFoundException("Article with id=%d not found".formatted(id));
        }
        articleRepository.delete(article);
    }

    // @Override
    // public Collection<Article> getByReference(String reference) {
    //     return articleRepository.getByReference(reference);
    // }

    @Override
    public Article get(Long id) throws EntityNotFoundException {
        Article article = articleRepository.get(id);
        if (article == null) {
            throw new EntityNotFoundException("Article with id=%d not found".formatted(id));
        }
        return article;
    }

    @Override
    public Collection<Article> list() {
        return articleRepository.all();
    }

    @Override
    public Article update(Article article) throws EntityNotFoundException {
        Article existingArticle = get(article.getId());
        if (existingArticle == null) {
            throw new EntityNotFoundException("Article with id=%d not found".formatted(article.getId()));
        }
        // existingArticle.setName(article.getName());
        // existingArticle.setDescription(article.getDescription());
        // existingArticle.setPrice(article.getPrice());
        // existingArticle.setReference(article.getReference());
        // existingArticle.setImageUrl(article.getImageUrl());
        // existingArticle.setQuantity(article.getQuantity());
        return articleRepository.save(existingArticle);
    }

}
