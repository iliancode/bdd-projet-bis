package fr.uga.l3miage.photonum.Adresse;

import jakarta.validation.constraints.NotBlank;

public record AdresseDTO(
    Long id,
    @NotBlank(message = "numeroRue is mandatory")
    int numeroRue,
    @NotBlank(message = "rue is mandatory")
    String rue,
    @NotBlank(message = "ville is mandatory")
    String ville,
    @NotBlank(message = "codePostal is mandatory")
    String codePostal,
    @NotBlank(message = "pays is mandatory")
    String pays
) {
    
}
