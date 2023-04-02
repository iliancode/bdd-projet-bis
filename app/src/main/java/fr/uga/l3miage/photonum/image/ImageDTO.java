package fr.uga.l3miage.photonum.image;

import java.util.Collection;

import fr.uga.l3miage.photonum.client.ClientDTO;
import jakarta.validation.constraints.Null;

public record ImageDTO (
    Long id,
    String chemin,
    Float resolutionPx,
    String infoPdv,
    Boolean partagee,

    @Null
    Collection<ClientDTO> Clients
)
{

}