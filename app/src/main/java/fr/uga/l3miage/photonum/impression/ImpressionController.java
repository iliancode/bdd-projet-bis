package fr.uga.l3miage.photonum.impression;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Impression;
import fr.uga.l3miage.photonum.service.ClientService;
import fr.uga.l3miage.photonum.service.EntityNotFoundException;
import fr.uga.l3miage.photonum.service.ImpressionService;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class ImpressionController {

    private final ImpressionService impressionService;
    private final ImpressionMapper impressionMapper;
    private final ClientService clientService;
    

    @Autowired
    public ImpressionController(ImpressionService impressionService, ImpressionMapper impressionMapper, ClientService clientService) {
        this.impressionService = impressionService;
        this.impressionMapper = impressionMapper;
        this.clientService = clientService;
    }

    @GetMapping("/impressions")
    public Collection<ImpressionDTO> getAllImpressions() {
        Collection<Impression> impressions = impressionService.list();

        return impressions.stream()
                .map(impressionMapper::entityToDTO)
                .toList();
    }

    @PostMapping("/client/{idClient}/impressions")
    @ResponseStatus(HttpStatus.CREATED)
    public ImpressionDTO createImpression(@PathVariable Long idClient , @RequestBody ImpressionDTO impression) throws EntityNotFoundException {


        Impression newImpression = impressionService.saveWithId(idClient, impressionMapper.dtoToEntity(impression));
        
       

        return impressionMapper.entityToDTO(newImpression);
    }

    

}
