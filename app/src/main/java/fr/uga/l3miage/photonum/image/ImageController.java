package fr.uga.l3miage.photonum.image;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.service.ImageService;

@RestController
@RequestMapping(value  = "/api/v1", produces = "application/json")
public class ImageController {

    private final ImageService imageService;
    private final ImageMapper imageMapper;

    @Autowired
    public ImageController(ImageService imageService, ImageMapper imageMapper) {
        this.imageService = imageService;
        this.imageMapper = imageMapper;
    }

    @GetMapping("/images")
    public Collection<ImageDTO> getAllImages() {
        Collection<Image> image = imageService.list();

        System.out.println(imageMapper.entityToDTO(image).toString());
        return image.stream()
        .map(imageMapper::entityToDTO)
        .toList();
    }


    @PostMapping(value = "/images" ,consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.CREATED)
    public ImageDTO createImage(@RequestBody ImageDTO imageDTO) {
        Image image = imageMapper.dtoToEntity(imageDTO);
        image = imageService.save(image);
        return imageMapper.entityToDTO(image);
    }
    
}

