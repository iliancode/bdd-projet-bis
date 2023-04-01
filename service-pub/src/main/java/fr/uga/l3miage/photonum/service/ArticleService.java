package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.service.base.BaseService;

public interface ArticleService extends BaseService<Article, Long> {

    Article save(Article article);

    void delete(Long id) throws EntityNotFoundException;

    // Collection<Article> getByReference(String reference);

}
