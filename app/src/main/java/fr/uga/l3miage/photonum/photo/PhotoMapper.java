package fr.uga.l3miage.photonum.photo;

import fr.uga.l3miage.photonum.data.domain.Photo;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    PhotoDTO entityToDTO(Photo photo);

    Collection<PhotoDTO> entityToDTO(Iterable<Photo> photo);

    Photo dtoToEntity(PhotoDTO impression);

    Collection<Photo> dtoToEntity(Iterable<PhotoDTO> impression);
}