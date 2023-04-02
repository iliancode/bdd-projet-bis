package fr.uga.l3miage.photonum.Article;

import java.util.Collection;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.service.ArticleService;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleController(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    /**
     * Retrieves all articles from the database
     *
     * @return a collection of ArticleDTOs
     */
    @GetMapping("/articles")
    public Collection<ArticleDTO> getAllArticles() {
        Collection<Article> articles = articleService.list();

        // map the collection of Article entities to a collection of ArticleDTOs
        return articles.stream()
                .map(articleMapper::entityToDTO)
                .toList();
    }

    /**
     * Creates a new article
     *
     * @param articleDTO the ArticleDTO representing the article to be created
     * @return the created ArticleDTO
     */
    @PostMapping("/articles")
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleDTO createArticle(@RequestBody @Valid ArticleDTO articleDTO){

        // map the ArticleDTO to an Article entity and save it to the database
        var saved = articleService.save(articleMapper.dtoToEntity(articleDTO));

        // map the saved Article entity back to an ArticleDTO and return it
        return articleMapper.entityToDTO(saved);
    }

    /**
     * Updates an existing article
     *
     * @param id the id of the article to be updated
     * @param articleDTO the ArticleDTO representing the updated article
     * @return the updated ArticleDTO
     * @throws EntityNotFoundException if the article with the given id is not found
     */
    @PutMapping("/articles/{id}")
    public ArticleDTO updateArticle(@PathVariable Long id, @RequestBody @Valid ArticleDTO articleDTO)
            throws EntityNotFoundException {

        // map the ArticleDTO to an Article entity
        Article article = articleMapper.dtoToEntity(articleDTO);

        // set the id of the article to the given id
        article.setId(id);

        // update the article in the database
        var updated = articleService.update(article);

        // map the updated Article entity back to an ArticleDTO and return it
        return articleMapper.entityToDTO(updated);
    }

    /**
     * Deletes an existing article
     *
     * @param id the id of the article to be deleted
     * @throws EntityNotFoundException if the article with the given id is not found
     */
    @DeleteMapping("/articles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable Long id) throws EntityNotFoundException {
        articleService.delete(id);
    }
}
