package fr.uga.l3miage.photonum.data.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Commande;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class CommandeRepository implements CRUDRepository<Long, Commande> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Commande save(Commande commande) {
        entityManager.persist(commande);
        return commande;
    }

    @Override
    public void delete(Commande commande) {
        entityManager.remove(commande);
    }

    @Override
    public Commande get(Long id) {
        return entityManager.find(Commande.class, id);
    }

    @Override
    public List<Commande> all() {
        TypedQuery<Commande> query = entityManager.createQuery("SELECT c FROM Commande c", Commande.class);
        return query.getResultList();
    }

    
    public Collection<Commande> getByClient(Client client) {
        TypedQuery<Commande> query = entityManager.createQuery(
                "SELECT c FROM Commande c JOIN c.clientCommande cc WHERE cc.id = :clientId", Commande.class);
        query.setParameter("clientId", client.getId());
        return query.getResultList();
    }

    // TODO: tester ca
    public Commande detailsCommande(Long id){

        TypedQuery<Commande> query = entityManager.createQuery(
        "SELECT c FROM Commande c JOIN FETCH c.clientCommande WHERE c.id = :id", 
        Commande.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
