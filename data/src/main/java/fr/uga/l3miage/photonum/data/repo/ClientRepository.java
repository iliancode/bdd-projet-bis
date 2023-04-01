package fr.uga.l3miage.photonum.data.repo;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.data.domain.Image;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository implements CRUDRepository<String, Client> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Client save(Client client) {
        entityManager.persist(client);
        return client;
    }

    @Override
    public Client get(String mail) {
        return entityManager.find(Client.class, mail);
    }

    @Override
    public void delete(Client client) {
        entityManager.remove(client);
    }

    @Override
    public List<Client> all() {
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    public List<Client> searchByMail(String mail) {
        return entityManager.createQuery("SELECT c FROM Client c WHERE c.mail = :mail", Client.class)
                .setParameter("mail", mail)
                .getResultList();
    }

    public Client addCommande(int id, String mail) {
        Client client = get(mail);
        Commande commande = entityManager.find(Commande.class, id);
        client.addCommande(commande);
        entityManager.persist(client);
        return client;
    }

    public List<Client> findAll(){
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    public List<Client> findByAdresse(Adresse adresse) {
        return entityManager.createQuery("SELECT c FROM Client c WHERE c.adresse = :adresse", Client.class)
        .setParameter("adresse", adresse)
        .getResultList();
    }

    public List<Client> findByImage(Image image) {
        return entityManager.createQuery("SELECT c FROM Client c WHERE c.image = :image", Client.class)
             .setParameter("image", image)
             .getResultList();
    }

    public List<Client> findByImagePartager(boolean partager) {
        return entityManager.createQuery("SELECT c FROM Client c WHERE c.partage = :partager", Client.class)
              .setParameter("partager", partager)
              .getResultList();
    }

    public Client findByMail(String mail) {
        return null;
    }
}