package fr.uga.l3miage.photonum.Clients;

import fr.uga.l3miage.photonum.data.domain.Client;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-01T20:21:06+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ClientsMapperImpl implements ClientsMapper {

    @Override
    public ClientsDTO entityToDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        String mail = null;
        String nom = null;
        String prenom = null;
        String motDePasse = null;

        mail = client.getMail();
        nom = client.getNom();
        prenom = client.getPrenom();
        motDePasse = client.getMotDePasse();

        Long id = null;

        ClientsDTO clientsDTO = new ClientsDTO( id, mail, nom, prenom, motDePasse );

        return clientsDTO;
    }

    @Override
    public Collection<ClientsDTO> entityToDTO(Iterable<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        Collection<ClientsDTO> collection = new ArrayList<ClientsDTO>();
        for ( Client client : clients ) {
            collection.add( entityToDTO( client ) );
        }

        return collection;
    }

    @Override
    public Client dtoToEntity(ClientsDTO client) {
        if ( client == null ) {
            return null;
        }

        Client client1 = new Client();

        client1.setMail( client.mail() );
        client1.setMotDePasse( client.motDePasse() );
        client1.setNom( client.nom() );
        client1.setPrenom( client.prenom() );

        return client1;
    }

    @Override
    public Collection<Client> dtoToEntity(Iterable<ClientsDTO> client) {
        if ( client == null ) {
            return null;
        }

        Collection<Client> collection = new ArrayList<Client>();
        for ( ClientsDTO clientsDTO : client ) {
            collection.add( dtoToEntity( clientsDTO ) );
        }

        return collection;
    }
}
