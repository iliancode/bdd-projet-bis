package fr.uga.l3miage.photonum.Clients;


import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.service.ClientService;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class ClientsController {
   
    
    private final ClientService clientService;
    private final ClientsMapper clientMapper;

    @Autowired
    public ClientsController(ClientService clientService, ClientsMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping(value = "/clients")
    public Collection<ClientsDTO> getAllClients() {
        Collection<Client> client = clientService.list();

        System.out.println(clientMapper.entityToDTO(client).toString());
        return client.stream()
                .map(clientMapper::entityToDTO)
                .toList();
    }

    @PostMapping(value = "/clients", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ClientsDTO createClient(@RequestBody @Valid ClientsDTO client){

        Client newClient = clientMapper.dtoToEntity(client);

        
        newClient = clientService.save(newClient);
        return clientMapper.entityToDTO(newClient);
    }
}
