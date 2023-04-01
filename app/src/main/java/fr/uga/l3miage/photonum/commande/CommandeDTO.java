package fr.uga.l3miage.photonum.commande;

import fr.uga.l3miage.photonum.client.ClientDTO;
import fr.uga.l3miage.photonum.article.ArticleDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public record CommandeDTO(
        Long id,
        @NotNull(message = "dateCommande is mandatory")
        Date dateCommande,
        @NotNull(message = "prixTotal is mandatory")
        @Min(value = 0, message = "prixTotal should be greater than or equal to 0")
        Float prixTotal,
        @NotNull(message = "clientCommande is mandatory")
        ClientDTO clientCommande,
        List<ArticleDTO> articles
) {

}
