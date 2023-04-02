package fr.uga.l3miage.photonum.Photo;

import fr.uga.l3miage.photonum.Clients.ClientsDTO;
import fr.uga.l3miage.photonum.Image.ImageDTO;
import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Photo;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T00:52:22+0200",
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
        ImageDTO image = null;
        String texteDescriptif = null;
        String parametreRetouche = null;

        id = photo.getId();
        image = imageToImageDTO( photo.getImage() );
        texteDescriptif = photo.getTexteDescriptif();
        parametreRetouche = photo.getParametreRetouche();

        PhotoDTO photoDTO = new PhotoDTO( id, image, texteDescriptif, parametreRetouche );

        return photoDTO;
    }

    @Override
    public Collection<Photo> entityToDTO(Iterable<Photo> photo) {
        if ( photo == null ) {
            return null;
        }

        Collection<Photo> collection = new ArrayList<Photo>();
        for ( Photo photo1 : photo ) {
            collection.add( photo1 );
        }

        return collection;
    }

    @Override
    public Photo dtoToEntity(PhotoDTO photo) {
        if ( photo == null ) {
            return null;
        }

        Photo photo1 = new Photo();

        photo1.setId( photo.id() );
        photo1.setImage( imageDTOToImage( photo.image() ) );
        photo1.setParametreRetouche( photo.parametreRetouche() );
        photo1.setTexteDescriptif( photo.texteDescriptif() );

        return photo1;
    }

    @Override
    public Collection<Photo> dtoToEntity(Iterable<PhotoDTO> photo) {
        if ( photo == null ) {
            return null;
        }

        Collection<Photo> collection = new ArrayList<Photo>();
        for ( PhotoDTO photoDTO : photo ) {
            collection.add( dtoToEntity( photoDTO ) );
        }

        return collection;
    }

    protected ImageDTO imageToImageDTO(Image image) {
        if ( image == null ) {
            return null;
        }

        Long id = null;
        String chemin = null;
        Float resolutionPx = null;
        String infoPdv = null;
        Boolean partagee = null;

        id = image.getId();
        chemin = image.getChemin();
        resolutionPx = image.getResolutionPx();
        infoPdv = image.getInfoPdv();
        partagee = image.isPartagee();

        Collection<ClientsDTO> clients = null;

        ImageDTO imageDTO = new ImageDTO( id, chemin, resolutionPx, infoPdv, partagee, clients );

        return imageDTO;
    }

    protected Image imageDTOToImage(ImageDTO imageDTO) {
        if ( imageDTO == null ) {
            return null;
        }

        Image image = new Image();

        image.setChemin( imageDTO.chemin() );
        image.setId( imageDTO.id() );
        image.setInfoPdv( imageDTO.infoPdv() );
        if ( imageDTO.partagee() != null ) {
            image.setPartagee( imageDTO.partagee() );
        }
        image.setResolutionPx( imageDTO.resolutionPx() );

        return image;
    }
}
