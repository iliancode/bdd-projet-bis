package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Impression;
import fr.uga.l3miage.photonum.data.repo.ImpressionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@org.springframework.transaction.annotation.Transactional
public class ImpressionServiceImpl implements ImpressionService {

    private final ImpressionRepository authorRepository;

    @Autowired
    public ImpressionServiceImpl(ImpressionRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Impression save(Impression impression) {
        return null;
    }

    @Override
    public Impression get(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public Collection<Impression> list() {
        return null;
    }

    @Override
    public Impression update(Impression object) throws EntityNotFoundException {
        return null;
    }
}
