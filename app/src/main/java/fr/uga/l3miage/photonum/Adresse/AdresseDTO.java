package fr.uga.l3miage.photonum.Adresse;

public record AdresseDTO(
    Long id,
    int numeroRue,
    String rue,
    String ville,
    String codePostal,
    String pays
) {
    
}
