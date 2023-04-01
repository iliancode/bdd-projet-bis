package fr.uga.l3miage.photonum.Image;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.data.domain.Image;

@Mapper (componentModel = "spring")
public interface ImageMapper {
    ImageDTO entityToDTO (Image image);
    
    Collection<ImageDTO> entityToDTO (Collection<Image> images);
    
    Image dtoToEntity (ImageDTO imageDTO);

    Collection<Image> dtoToEntity (Collection<ImageDTO> imageDTOs);
}