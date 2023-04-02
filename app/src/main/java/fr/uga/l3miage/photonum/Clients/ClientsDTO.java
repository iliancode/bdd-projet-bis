package fr.uga.l3miage.photonum.Clients;

import java.util.Collection;

import fr.uga.l3miage.photonum.Adresse.AdresseDTO;
<<<<<<< HEAD
import fr.uga.l3miage.photonum.Image.ImageDTO;
// import fr.uga.l3miage.photonum.Image.ImageDTO;
import jakarta.validation.constraints.NotBlank;
=======
>>>>>>> 3c1020d2f1a310c52b96c1f8f8cd823dfe96f99d
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
    Collection<ImageDTO> images
    //,
    // Collection<CommandeDTO> commandes,
    // Collection<ImpressionDTO> impressions
) {
    
}
