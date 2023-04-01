package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.service.base.BaseService;

public interface ClientService extends BaseService<Client,String> {
    Client save(Client client);
}