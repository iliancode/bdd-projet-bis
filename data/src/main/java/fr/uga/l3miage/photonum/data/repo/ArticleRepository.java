package fr.uga.l3miage.photonum.data.repo;

import fr.uga.l3miage.photonum.data.domain.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepository implements CRUDRepository<Long, Article> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Article save(Article article) {
        entityManager.persist(article);
        return article;
    }

    @Override
    public Article get(Long id) {
        return entityManager.find(Article.class, id);
    }

    @Override
    public void delete(Article article) {
        entityManager.remove(article);
    }

    @Override
    public List<Article> all() {
        return entityManager.createQuery("SELECT a FROM Article a", Article.class).getResultList();
    }
}