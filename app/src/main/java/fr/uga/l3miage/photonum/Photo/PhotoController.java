package fr.uga.l3miage.photonum.Photo;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import fr.uga.l3miage.photonum.service.PhotoService;

@RestController
@RequestMapping(value = "/api/v1/photos")
public class PhotoController {
    private final PhotoService photoService;
    private final PhotoMapper photoMapper;
    
    @Autowired
    public PhotoController(PhotoService photoService, PhotoMapper photoMapper) {
        this.photoService = photoService;
        this.photoMapper = photoMapper;
    }

    @GetMapping("/photos")
    public Collection<PhotoDTO> getAllPhotos(){
        Collection<Photo> photo = photoService.list();
        System.out.println (photoMapper.entityToDTO(photo).toString());
        return photo.stream()
        .map(photoMapper::entityToDTO)
        .toList();
        
    }

    @PostMapping(value = "/photos",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus (code = HttpStatus.CREATED)
    @GetMapping("/photos/{id}")
    public PhotoDTO getPhotoById(@PathVariable Long id) throws EntityNotFoundException{
        Photo photo = photoService.get(id);
        photo = photoService.save(photo);
        return photoMapper.entityToDTO(photo);
    }
    

}