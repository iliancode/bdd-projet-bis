package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.service.base.BaseService;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface CommandeService extends BaseService<Commande, Long> {

    Commande save(Commande commande);

    void delete(Long id) throws EntityNotFoundException;

    Collection<Commande> getByClient(Client client);

    Commande detailsCommande(Long id);

}
