package fr.uga.l3miage.photonum.photo;

import jakarta.validation.constraints.NotBlank;

public record PhotoDTO(
    @NotBlank(message = "id is mandatory")
    Long id,
    String texteDescriptif,
    String parametreRetouche
    //@Null
    //ImageDTO image

) {
}
