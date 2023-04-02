package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.data.repo.ImageRepository;
import fr.uga.l3miage.photonum.data.repo.PhotoRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final PhotoRepository photoRepository;
    // private final PhotoRepository photoRepository;
    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, PhotoRepository photoRepository) {
        this.imageRepository = imageRepository;
        this.photoRepository = photoRepository;
    }   

    @Override
    public Image get(Long id) throws EntityNotFoundException {
        return imageRepository.get(id);
    }
    @Override 
    public Collection<Image> list() {
        return imageRepository.all();
    }
    @Override 
    public Image update(Image image) throws EntityNotFoundException {
        return imageRepository.save(image);
    }
    @Override 
    public Image save(Image image) {
        return imageRepository.save(image);
    }


    //Modifier Image
    public Image modifierImageChemin(Image image, String chemin) {
        image.setChemin(chemin);
        return image;
    }
    public Image modifierImageResolutionPx(Image image, Float resolutionPx) {
        image.setResolutionPx(resolutionPx);
        return image;
    }
    public Image modifierImageInfoPdv (Image image, String infoPdv) {
        image.setInfoPdv(infoPdv);
        return image;
    }

    //Supprimer Image

    @Override
    public void delete(Long id) throws EntityNotFoundException { 
        Image image = imageRepository.get(id);

        if (image != null) {
            if (image.isPartagee() == false) {
                boolean imageIsUsed = false;
                Collection<Photo> photos = photoRepository.all();
                for (Photo photo : photos) {
                    if (photo.getImage() == image) {
                        imageIsUsed = true;
                        break;
                    }
                }
                if (imageIsUsed == false) {
                    imageRepository.delete(image);
                }else {
                    throw new EntityNotFoundException("l'image est lier a une photo");
                }
            }else {
                throw new EntityNotFoundException("l'image est partagee");
            } 
        }else {
            throw new EntityNotFoundException(null);
        }
    }
}
