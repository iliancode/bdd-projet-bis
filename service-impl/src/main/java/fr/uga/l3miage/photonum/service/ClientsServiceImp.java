package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;
import jakarta.transaction.Transactional;

@Service 
@Transactional
public class ClientsServiceImp implements ClientService {

    private final ClientRepository clientRepository;
    
    @Autowired
    public ClientsServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
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





    @Override
    public Client get(Long id) throws EntityNotFoundException {
       return clientRepository.get(id);
    }

}