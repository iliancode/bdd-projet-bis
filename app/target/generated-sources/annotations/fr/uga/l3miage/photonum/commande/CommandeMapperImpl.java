package fr.uga.l3miage.photonum.commande;

import fr.uga.l3miage.photonum.article.ArticleDTO;
import fr.uga.l3miage.photonum.client.ClientDTO;
import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.impression.ImpressionDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-01T23:57:42+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class CommandeMapperImpl implements CommandeMapper {

    @Override
    public CommandeDTO entityToDTO(Commande commande) {
        if ( commande == null ) {
            return null;
        }

        List<ArticleDTO> articles = null;

        articles = articleCollectionToArticleDTOList( commande.getArticles() );

        Long id = null;
        Date dateCommande = null;
        Float prixTotal = null;
        ClientDTO clientCommande = null;

        CommandeDTO commandeDTO = new CommandeDTO( id, dateCommande, prixTotal, clientCommande, articles );

        return commandeDTO;
    }

    @Override
    public Commande dtoToEntity(CommandeDTO commandeDTO) {
        if ( commandeDTO == null ) {
            return null;
        }

        Commande commande = new Commande();

        commande.setArticles( articleDTOListToArticleList( commandeDTO.articles() ) );

        return commande;
    }

    protected ArticleDTO articleToArticleDTO(Article article) {
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

    protected List<ArticleDTO> articleCollectionToArticleDTOList(Collection<Article> collection) {
        if ( collection == null ) {
            return null;
        }

        List<ArticleDTO> list = new ArrayList<ArticleDTO>( collection.size() );
        for ( Article article : collection ) {
            list.add( articleToArticleDTO( article ) );
        }

        return list;
    }

    protected Article articleDTOToArticle(ArticleDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        Article article = new Article();

        article.setId( articleDTO.id() );

        return article;
    }

    protected List<Article> articleDTOListToArticleList(List<ArticleDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Article> list1 = new ArrayList<Article>( list.size() );
        for ( ArticleDTO articleDTO : list ) {
            list1.add( articleDTOToArticle( articleDTO ) );
        }

        return list1;
    }
}
