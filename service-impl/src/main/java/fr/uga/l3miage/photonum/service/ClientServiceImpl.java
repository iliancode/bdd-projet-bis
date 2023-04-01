package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;
import jakarta.transaction.Transactional;

@Service 
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    @Override
    public Client get(String mail) throws EntityNotFoundException {
        return clientRepository.findByMail(mail);
    }

    @Override
    public Collection<Client> list()  {
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

}