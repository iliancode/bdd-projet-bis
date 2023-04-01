package fr.uga.l3miage.photonum.Article;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.impression.ImpressionDTO;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-01T20:48:10+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ArticleMapperImpl implements ArticleMapper {

    @Override
    public ArticleDTO entityToDTO(Article article) {
        if ( article == null ) {
            return null;
        }

        Long id = null;

        id = article.getId();

        float price = 0.0f;
        int quantity = 0;
        String reference = null;
        ImpressionDTO impression = null;

        ArticleDTO articleDTO = new ArticleDTO( id, price, quantity, reference, impression );

        return articleDTO;
    }

    @Override
    public Collection<ArticleDTO> entityToDTO(Iterable<Article> articles) {
        if ( articles == null ) {
            return null;
        }

        Collection<ArticleDTO> collection = new ArrayList<ArticleDTO>();
        for ( Article article : articles ) {
            collection.add( entityToDTO( article ) );
        }

        return collection;
    }

    @Override
    public Article dtoToEntity(ArticleDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        Article article = new Article();

        article.setId( articleDTO.id() );

        return article;
    }

    @Override
    public Collection<Article> dtoToEntity(Iterable<ArticleDTO> articleDTOs) {
        if ( articleDTOs == null ) {
            return null;
        }

        Collection<Article> collection = new ArrayList<Article>();
        for ( ArticleDTO articleDTO : articleDTOs ) {
            collection.add( dtoToEntity( articleDTO ) );
        }

        return collection;
    }
}
