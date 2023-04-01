package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.data.repo.CommandeRepository;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepository commandeRepository;

    @Autowired
    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Commande commande = get(id);
        if (commande == null) {
            throw new EntityNotFoundException("Commande with id=%d not found".formatted(id));
        }
        commandeRepository.delete(commande);
    }

    @Override
    public Commande get(Long id) throws EntityNotFoundException {
        Commande commande = commandeRepository.get(id);
        if (commande == null) {
            throw new EntityNotFoundException("Commande with id=%d not found".formatted(id));
        }
        return commande;
    }

    @Override
    public Collection<Commande> list() {
        return commandeRepository.all();
    }

    @Override
    public Commande update(Commande commande) throws EntityNotFoundException {
        

        return commandeRepository.save(commande);
    }

    @Override
    public Collection<Commande> getByClient(Client client) {
        return commandeRepository.getByClient(client);
    }
}
