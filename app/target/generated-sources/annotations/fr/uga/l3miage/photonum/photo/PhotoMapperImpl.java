package fr.uga.l3miage.photonum.photo;

import fr.uga.l3miage.photonum.data.domain.Photo;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-02T00:00:42+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class PhotoMapperImpl implements PhotoMapper {

    @Override
    public PhotoDTO entityToDTO(Photo photo) {
        if ( photo == null ) {
            return null;
        }

        Long id = null;
        String texteDescriptif = null;
        String parametreRetouche = null;

        PhotoDTO photoDTO = new PhotoDTO( id, texteDescriptif, parametreRetouche );

        return photoDTO;
    }

    @Override
    public Collection<PhotoDTO> entityToDTO(Iterable<Photo> photo) {
        if ( photo == null ) {
            return null;
        }

        Collection<PhotoDTO> collection = new ArrayList<PhotoDTO>();
        for ( Photo photo1 : photo ) {
            collection.add( entityToDTO( photo1 ) );
        }

        return collection;
    }

    @Override
    public Photo dtoToEntity(PhotoDTO impression) {
        if ( impression == null ) {
            return null;
        }

        Photo photo = new Photo();

        return photo;
    }

    @Override
    public Collection<Photo> dtoToEntity(Iterable<PhotoDTO> impression) {
        if ( impression == null ) {
            return null;
        }

        Collection<Photo> collection = new ArrayList<Photo>();
        for ( PhotoDTO photoDTO : impression ) {
            collection.add( dtoToEntity( photoDTO ) );
        }

        return collection;
    }
}
