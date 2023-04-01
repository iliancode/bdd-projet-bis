package fr.uga.l3miage.photonum.data.repo;


import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Image;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ClientRepositoryTest extends Base{
    @Autowired
    private ClientRepository clientRepository;
    
    @Test 
    void findAll() {
        Client c1 = Fixtures.newClient();
        c1.addAdresse(Fixtures.newAdresse());
        c1.addImage(Fixtures.newImage());
        Client c2 = Fixtures.newClient();
        c2.addAdresse(Fixtures.newAdresse());
        c2.addImage(Fixtures.newImage());
        entityManager.persist(c1);
        entityManager.persist(c2);
        List<Client> clients = clientRepository.findAll();
        assertThat(clients).isNotNull();
        assertThat(clients).isNotEmpty();
        assertThat(clients).hasSize(2);
        assertThat(clients.get(0)).isEqualTo(c1);
        assertThat(clients.get(1)).isEqualTo(c2);
        clientRepository.delete(c1);
        clientRepository.delete(c2);
    }

    @Test 
    void searchByMail() {
        Client c1 = Fixtures.newClient();
        c1.addAdresse(Fixtures.newAdresse());
        c1.addImage(Fixtures.newImage());
        Client c2 = Fixtures.newClient();
        c2.addAdresse(Fixtures.newAdresse());
        c2.addImage(Fixtures.newImage());
        entityManager.persist(c1);
        entityManager.persist(c2);

        List<Client> clients = clientRepository.searchByMail(c1.getMail());
        assertThat(clients).isNotNull();
        assertThat(clients).isNotEmpty();
        assertThat(clients).hasSize(1);
        assertThat(clients.get(0)).isEqualTo(c1);
        clientRepository.delete(c1);
        clientRepository.delete(c2);
    }

    @Test 
    void findByAdresse(){
        Client c1 = Fixtures.newClient();
        Adresse a1 = Fixtures.newAdresse();
        c1.addAdresse(a1);
        c1.addImage(Fixtures.newImage());
        Client c2 = Fixtures.newClient();
        c2.addAdresse(Fixtures.newAdresse());
        c2.addImage(Fixtures.newImage());
        entityManager.persist(c1);
        entityManager.persist(c2);
        List<Client> clients = clientRepository.findByAdresse(a1);
        assertThat(clients).isNotNull();
        assertThat(clients).isNotEmpty();
        assertThat(clients).hasSize(1);
        assertThat(clients.get(0)).isEqualTo(c1);
        c2.addAdresse(a1);
        clients = clientRepository.findByAdresse(a1);
        assertThat(clients).isNotNull();
        assertThat(clients).isNotEmpty();
        assertThat(clients).hasSize(2);
        assertThat(clients.get(0)).isEqualTo(c1);
        assertThat(clients.get(1)).isNotEqualTo(c2);
        clientRepository.delete(c1);
        clientRepository.delete(c2);        
    }

    @Test 
    void findByImage(){
        Client c1 = Fixtures.newClient();
        c1.addAdresse(Fixtures.newAdresse());
        Image a1 = Fixtures.newImage();
        c1.addImage(a1);
        Client c2 = Fixtures.newClient();
        c2.addAdresse(Fixtures.newAdresse());
        c2.addImage(Fixtures.newImage());

        entityManager.persist(c1);
        entityManager.persist(c2);

        List<Client> clients = clientRepository.findByImage(a1);
        assertThat(clients).isNotNull();
        assertThat(clients).isNotEmpty();
        assertThat(clients).hasSize(1);
        assertThat(clients.get(0)).isEqualTo(c1);
    }

    @Test 
    void findByImagePartagers() {
        Client c1 = Fixtures.newClient();
        c1.addAdresse(Fixtures.newAdresse());
        Image a1 = Fixtures.newImage();
        a1.setPartagee(true);
        c1.addImage(a1);
        Client c2 = Fixtures.newClient();
        c2.addAdresse(Fixtures.newAdresse());
        c2.addImage(Fixtures.newImage());
        entityManager.persist(c1);
        entityManager.persist(c2);
        List<Client> clients = clientRepository.findByImagePartager(true);
        assertThat(clients).isNotNull();
        assertThat(clients).isNotEmpty();
        assertThat(clients).hasSize(1);
        assertThat(clients.get(0)).isEqualTo(c1);
        clients = clientRepository.findByImagePartager(false);
        assertThat(clients).isNotNull();
        assertThat(clients).isNotEmpty();
        assertThat(clients).hasSize(1);
        assertThat(clients.get(0)).isEqualTo(c2);
        clientRepository.delete(c1);
        clientRepository.delete(c2);
    }
}