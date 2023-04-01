package fr.uga.l3miage.photonum.page;

import fr.uga.l3miage.photonum.data.domain.Page;
import fr.uga.l3miage.photonum.photo.PhotoDTO;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-01T23:37:00+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class PageMapperImpl implements PageMapper {

    @Override
    public PageDTO entityToDTO(Page page) {
        if ( page == null ) {
            return null;
        }

        Long id = null;
        Collection<PhotoDTO> photos = null;

        PageDTO pageDTO = new PageDTO( id, photos );

        return pageDTO;
    }

    @Override
    public Collection<PageDTO> entityToDTO(Iterable<Page> page) {
        if ( page == null ) {
            return null;
        }

        Collection<PageDTO> collection = new ArrayList<PageDTO>();
        for ( Page page1 : page ) {
            collection.add( entityToDTO( page1 ) );
        }

        return collection;
    }

    @Override
    public Page dtoToEntity(PageDTO page) {
        if ( page == null ) {
            return null;
        }

        Page page1 = new Page();

        return page1;
    }

    @Override
    public Collection<Page> dtoToEntity(Iterable<PageDTO> page) {
        if ( page == null ) {
            return null;
        }

        Collection<Page> collection = new ArrayList<Page>();
        for ( PageDTO pageDTO : page ) {
            collection.add( dtoToEntity( pageDTO ) );
        }

        return collection;
    }
}
