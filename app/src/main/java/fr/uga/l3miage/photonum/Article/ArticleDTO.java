package fr.uga.l3miage.photonum.article;

import fr.uga.l3miage.photonum.impression.ImpressionDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ArticleDTO(
    Long id,
    @Min(value = 0, message = "price should be greater than or equal to 0")
    float price,
    @Min(value = 1, message = "quantity should be greater than 0")
    int quantity,
    @NotBlank(message = "reference is mandatory")
    String reference,
    ImpressionDTO impression
) {

    
}
