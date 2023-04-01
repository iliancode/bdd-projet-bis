package fr.uga.l3miage.photonum.impression;

import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Impression;
import fr.uga.l3miage.photonum.service.ImpressionService;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class ImpressionController {

    private final ImpressionService impressionService;
    private final ImpressionMapper impressionMapper;

    @Autowired
    public ImpressionController(ImpressionService impressionService, ImpressionMapper impressionMapper) {
        this.impressionService = impressionService;
        this.impressionMapper = impressionMapper;
    }

    @GetMapping("/impressions")
    public Collection<ImpressionDTO> getAllImpressions() {
        Collection<Impression> impressions = impressionService.list();

        return impressions.stream()
                .map(impressionMapper::entityToDTO)
                .toList();
    }

    @PostMapping("/impressions")
    @ResponseStatus(HttpStatus.CREATED)
    public ImpressionDTO createImpression(@RequestBody ImpressionDTO impression){

        var saved = impressionService.save(impressionMapper.dtoToEntity(impression));
        return impressionMapper.entityToDTO(saved);
    }

}
