package fr.uga.l3miage.photonum.photo;

import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.service.ImpressionService;
import fr.uga.l3miage.photonum.service.PhotoService;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class PhotoController {

    private final PhotoService photoService;
    private final PhotoMapper photoMapper;

    @Autowired
    public PhotoController(PhotoService photoService, PhotoMapper photoMapper) {
        this.photoService = photoService;
        this.photoMapper = photoMapper;
    }

    @GetMapping("/photos")
    public Collection<PhotoDTO> getAllPhotos() {
        Collection<Photo> photos = photoService.list();

        return photos.stream()
                .map(photoMapper::entityToDTO)
                .toList();
    }

    

}
