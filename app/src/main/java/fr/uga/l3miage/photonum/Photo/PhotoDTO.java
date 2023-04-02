package fr.uga.l3miage.photonum.Photo;



import fr.uga.l3miage.photonum.Image.ImageDTO;
import jakarta.validation.constraints.NotBlank;


public record PhotoDTO(
    Long id,
    @NotBlank( message = "message Image est neccessaire")
    ImageDTO image,

    String texteDescriptif,
    String parametreRetouche
){

}