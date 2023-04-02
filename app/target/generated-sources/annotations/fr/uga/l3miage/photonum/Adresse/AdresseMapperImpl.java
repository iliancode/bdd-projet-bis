package fr.uga.l3miage.photonum.Adresse;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-02T21:56:57+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class AdresseMapperImpl implements AdresseMapper {

    @Override
    public AdresseDTO entityToDTO(Adresse adresse) {
        if ( adresse == null ) {
            return null;
        }

        Long id = null;
        int numeroRue = 0;
        String rue = null;
        String ville = null;
        String codePostal = null;
        String pays = null;

        id = adresse.getId();
        numeroRue = adresse.getNumeroRue();
        rue = adresse.getRue();
        ville = adresse.getVille();
        codePostal = adresse.getCodePostal();
        pays = adresse.getPays();

        AdresseDTO adresseDTO = new AdresseDTO( id, numeroRue, rue, ville, codePostal, pays );

        return adresseDTO;
    }

    @Override
    public Collection<AdresseDTO> entityToDTO(Iterable<Adresse> adresses) {
        if ( adresses == null ) {
            return null;
        }

        Collection<AdresseDTO> collection = new ArrayList<AdresseDTO>();
        for ( Adresse adresse : adresses ) {
            collection.add( entityToDTO( adresse ) );
        }

        return collection;
    }

    @Override
    public Adresse dtoToEntity(AdresseDTO adresse) {
        if ( adresse == null ) {
            return null;
        }

        Adresse adresse1 = new Adresse();

        adresse1.setCodePostal( adresse.codePostal() );
        if ( adresse.id() != null ) {
            adresse1.setId( adresse.id() );
        }
        adresse1.setNumeroRue( adresse.numeroRue() );
        adresse1.setPays( adresse.pays() );
        adresse1.setRue( adresse.rue() );
        adresse1.setVille( adresse.ville() );

        return adresse1;
    }

    @Override
    public Collection<Adresse> dtoToEntity(Iterable<AdresseDTO> adresse) {
        if ( adresse == null ) {
            return null;
        }

        Collection<Adresse> collection = new ArrayList<Adresse>();
        for ( AdresseDTO adresseDTO : adresse ) {
            collection.add( dtoToEntity( adresseDTO ) );
        }

        return collection;
    }
}
