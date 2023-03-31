package fr.uga.l3miage.photonum.impression;

import fr.uga.l3miage.photonum.data.domain.Impression;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-31T10:11:39+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class ImpressionMapperImpl implements ImpressionMapper {

    @Override
    public ImpressionDTO entityToDTO(Impression impression) {
        if ( impression == null ) {
            return null;
        }

        ImpressionDTO impressionDTO = new ImpressionDTO();

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
