package fr.uga.l3miage.photonum.commande;

import fr.uga.l3miage.photonum.data.domain.Commande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandeMapper {

    CommandeDTO entityToDTO(Commande commande);
    
    Commande dtoToEntity(CommandeDTO commandeDTO);
}
