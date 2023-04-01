package fr.uga.l3miage.photonum.Clients;

import jakarta.validation.constraints.NotBlank;

public record ClientsDTO(
    Long id,
    String mail,
    String nom,
    String prenom,
    String motDePasse
) {
    
}
