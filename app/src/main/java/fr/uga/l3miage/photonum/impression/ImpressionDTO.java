package fr.uga.l3miage.photonum.impression;

import fr.uga.l3miage.photonum.data.domain.Client;
import jakarta.validation.constraints.NotBlank;
import main.java.fr.uga.l3miage.photonum.data.Enum.TypeImpression;

public record ImpressionDTO(
    Long id,
    @NotBlank(message = "typeImpression is mandatory")
    TypeImpression typeImpression
) {
}
