package fr.uga.l3miage.photonum.Clients;

import java.util.Collection;

import fr.uga.l3miage.photonum.Adresse.AdresseDTO;
import fr.uga.l3miage.photonum.Image.ImageDTO;
import fr.uga.l3miage.photonum.impression.ImpressionDTO;
import jakarta.validation.constraints.Null;

public record ClientsDTO(
    Long id,
    String mail,
    String nom,
    String prenom,
    String motDePasse,
    @Null
    Collection<AdresseDTO> adresses,
    @Null
    Collection<ImpressionDTO> impressions
   // , 
    //@Null
     //Collection<ImageDTO> images
   // ,
    // Collection<CommandeDTO> commandes,
    //@Null
   // Collection<ImpressionDTO> impressions
) {
    
}
