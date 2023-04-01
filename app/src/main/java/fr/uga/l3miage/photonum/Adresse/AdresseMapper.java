package fr.uga.l3miage.photonum.Adresse;


import fr.uga.l3miage.photonum.data.domain.Adresse;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface AdresseMapper {
    AdresseDTO entityToDTO(Adresse adresse);

    Collection<AdresseDTO> entityToDTO(Iterable<Adresse> adresses);

    Adresse dtoToEntity(AdresseDTO adresse);

    Collection<Adresse> dtoToEntity(Iterable<AdresseDTO> adresse);

}
