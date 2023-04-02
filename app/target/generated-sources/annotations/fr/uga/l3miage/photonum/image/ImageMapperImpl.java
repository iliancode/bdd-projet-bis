package fr.uga.l3miage.photonum.image;

import fr.uga.l3miage.photonum.client.ClientDTO;
import fr.uga.l3miage.photonum.data.domain.Image;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-02T14:02:26+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageDTO entityToDTO(Image image) {
        if ( image == null ) {
            return null;
        }

        Long id = null;
        String chemin = null;
        Float resolutionPx = null;
        String infoPdv = null;
        Boolean partagee = null;
        Collection<ClientDTO> clients = null;

        ImageDTO imageDTO = new ImageDTO( id, chemin, resolutionPx, infoPdv, partagee, clients );

        return imageDTO;
    }

    @Override
    public Collection<ImageDTO> entityToDTO(Collection<Image> images) {
        if ( images == null ) {
            return null;
        }

        Collection<ImageDTO> collection = new ArrayList<ImageDTO>( images.size() );
        for ( Image image : images ) {
            collection.add( entityToDTO( image ) );
        }

        return collection;
    }

    @Override
    public Image dtoToEntity(ImageDTO imageDTO) {
        if ( imageDTO == null ) {
            return null;
        }

        Image image = new Image();

        return image;
    }

    @Override
    public Collection<Image> dtoToEntity(Collection<ImageDTO> imageDTOs) {
        if ( imageDTOs == null ) {
            return null;
        }

        Collection<Image> collection = new ArrayList<Image>( imageDTOs.size() );
        for ( ImageDTO imageDTO : imageDTOs ) {
            collection.add( dtoToEntity( imageDTO ) );
        }

        return collection;
    }
}
