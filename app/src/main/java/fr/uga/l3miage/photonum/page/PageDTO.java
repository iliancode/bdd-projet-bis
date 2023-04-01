package fr.uga.l3miage.photonum.page;
import fr.uga.l3miage.photonum.photo.PhotoDTO;


import java.util.Collection;

import jakarta.validation.constraints.NotBlank;

public record PageDTO(
        @NotBlank(message = "id is mandatory")
        Long id,
        Collection<PhotoDTO> photos
) {
}
