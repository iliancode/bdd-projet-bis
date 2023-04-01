package fr.uga.l3miage.photonum.Image;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Image;

import java.util.Collection;

import fr.uga.l3miage.photonum.Clients.ClientsDTO;
import io.micrometer.common.lang.Nullable;
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