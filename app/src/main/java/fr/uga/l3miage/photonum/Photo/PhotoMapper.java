package fr.uga.l3miage.photonum.Photo;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.data.domain.Photo;

@Mapper (componentModel = "spring")
public interface PhotoMapper {
    PhotoDTO entityToDTO(Photo photo);

    Collection<Photo> entityToDTO(Iterable<Photo> photo);

    Photo dtoToEntity(PhotoDTO photo);
    
    Collection<Photo> dtoToEntity(Iterable<PhotoDTO> photo); 

}
