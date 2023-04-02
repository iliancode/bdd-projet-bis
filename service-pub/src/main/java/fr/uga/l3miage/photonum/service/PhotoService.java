package fr.uga.l3miage.photonum.service;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.service.base.BaseService;

public interface PhotoService extends BaseService<Photo,Long> {
    Photo save(Photo photo);
}
