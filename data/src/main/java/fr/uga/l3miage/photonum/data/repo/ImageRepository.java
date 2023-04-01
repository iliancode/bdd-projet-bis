package fr.uga.l3miage.photonum.data.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Image;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class ImageRepository implements CRUDRepository<Long, Image> {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Image save (Image image) {
        entityManager.persist(image);
        return image;
    }

    @Override
    public Image get (Long id) {
        return entityManager.find(Image.class, id);
    }

    @Override
    public void delete (Image Image) {
        entityManager.remove(Image);
    }

    @Override
    public List <Image> all(){
        return entityManager.createQuery("SELECT i FROM Image i ORDER BY id", Image.class).getResultList();
    }
}
