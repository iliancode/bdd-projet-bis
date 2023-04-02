package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Photo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class PhotoRepository implements CRUDRepository<Long,Photo> {
    @PersistenceContext
    private EntityManager em;

    @Override 
    public Photo save (Photo photo) {
        em.persist(photo);
        return photo;

    }
    @Override
    public Photo get(Long id) {
        return em.find(Photo.class, id);
    }

    @Override
    public void delete(Photo entity) {
        em.remove(entity);
    }
    @Override
    public List<Photo> all() {
        return em.createQuery("from Photo", Photo.class).getResultList();
        
    }

}
