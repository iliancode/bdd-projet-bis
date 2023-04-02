package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.data.repo.PhotoRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;

    @Autowired 
    PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }
    @Override
    public Photo get (Long id) {
        return photoRepository.get(id);
    }

    @Override
    public Collection<Photo> list(){
        return photoRepository.all();
    }

    @Override
    public Photo update(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }
    
}
