package fr.uga.l3miage.photonum.Clients;


import fr.uga.l3miage.photonum.data.domain.Client;

import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ClientsMapper {
    ClientsDTO entityToDTO(Client client);

    Collection<ClientsDTO> entityToDTO(Iterable<Client> clients);

    Client dtoToEntity(ClientsDTO client);

    Collection<Client> dtoToEntity(Iterable<ClientsDTO> client);

}
