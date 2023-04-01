package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.repo.ImageRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
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
}
