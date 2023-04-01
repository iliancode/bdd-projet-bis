package fr.uga.l3miage.photonum.impression;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Impression;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-01T15:06:59+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ImpressionMapperImpl implements ImpressionMapper {

    @Override
    public ImpressionDTO entityToDTO(Impression impression) {
        if ( impression == null ) {
            return null;
        }

        Long id = null;
        Client clientImpression = null;

        id = impression.getId();
        clientImpression = impression.getClientImpression();

        ImpressionDTO impressionDTO = new ImpressionDTO( id, clientImpression );

        return impressionDTO;
    }

    @Override
    public Collection<ImpressionDTO> entityToDTO(Iterable<Impression> authors) {
        if ( authors == null ) {
            return null;
        }

        Collection<ImpressionDTO> collection = new ArrayList<ImpressionDTO>();
        for ( Impression impression : authors ) {
            collection.add( entityToDTO( impression ) );
        }

        return collection;
    }

    @Override
    public Impression dtoToEntity(ImpressionDTO author) {
        if ( author == null ) {
            return null;
        }

        Impression impression = new Impression();

        impression.setClientImpression( author.clientImpression() );
        if ( author.id() != null ) {
            impression.setId( author.id() );
        }

        return impression;
    }

    @Override
    public Collection<Impression> dtoToEntity(Iterable<ImpressionDTO> authors) {
        if ( authors == null ) {
            return null;
        }

        Collection<Impression> collection = new ArrayList<Impression>();
        for ( ImpressionDTO impressionDTO : authors ) {
            collection.add( dtoToEntity( impressionDTO ) );
        }

        return collection;
    }
}
