package fr.uga.l3miage.photonum.Image;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
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
        Collection<Image> images = imageService.list();
        return images.stream()
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

    @GetMapping("/images/{id}")
    public ImageDTO getImage(@PathVariable Long id) throws EntityNotFoundException {
        Image image = imageService.get(id);
        return imageMapper.entityToDTO(image);
    }

    @PutMapping(value = "/images/{id}", consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.OK)
    public void updateImage(@PathVariable Long id, @RequestBody ImageDTO imageDTO) throws EntityNotFoundException {
        Image image = imageMapper.dtoToEntity(imageDTO);
        image.setId(id);
        imageService.save(image);
    }

    @PutMapping(value = "/images/{id}/chemin", consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.OK)
    public void updateImageChemin(@PathVariable Long id, @PathVariable String chemin) throws EntityNotFoundException {
        Image image = imageService.get(id);
        image.setChemin(chemin);
        imageService.save(image);
    }

    @PutMapping(value = "/images/{id}/px", consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.OK)
    public void updateImagePx(@PathVariable Long id, @PathVariable float px) throws EntityNotFoundException {
        Image image = imageService.get(id);
        image.setResolutionPx(px);
        imageService.save(image);
    }

    @PutMapping(value = "/images/{id}/pdv", consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.OK)
    public void updateImagePdv(@PathVariable Long id, @PathVariable String pdv) throws EntityNotFoundException {
        Image image = imageService.get(id);
        image.setInfoPdv(pdv);
        imageService.save(image);
    }

    @DeleteMapping(value = "/images/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable Long id) throws EntityNotFoundException {
        imageService.delete(id);
    }
}
