package fr.uga.l3miage.photonum.Image;

import java.util.Collection;

import fr.uga.l3miage.photonum.Clients.ClientsDTO;
import jakarta.validation.constraints.Null;

public record ImageDTO (
    Long id,
    String chemin,
    Float resolutionPx,
    String infoPdv,
    Boolean partagee,

    @Null
    Collection<ClientsDTO> Clients
)
{

}