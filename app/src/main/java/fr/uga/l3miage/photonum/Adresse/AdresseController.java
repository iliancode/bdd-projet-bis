package fr.uga.l3miage.photonum.Adresse;


import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.service.AdresseService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class AdresseController {
   
    
    private final AdresseService adresseService;
    private final AdresseMapper adresseMapper;


    @Autowired
    public AdresseController(AdresseService adresseService, AdresseMapper adresseMapper) {
        this.adresseService = adresseService;
        this.adresseMapper = adresseMapper;
    }

    @GetMapping(value = "/adresses")
    public Collection<AdresseDTO> getAllAdresses() {
        Collection<Adresse> adresse = adresseService.list();

        System.out.println(adresseMapper.entityToDTO(adresse).toString());
        return adresse.stream()
                .map(adresseMapper::entityToDTO)
                .toList();
    }

    @PostMapping(value = "/adresses", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AdresseDTO createAdresse(@RequestBody @Valid AdresseDTO adresse){

        Adresse newAdresse = adresseMapper.dtoToEntity(adresse);

        
        newAdresse = adresseService.save(newAdresse);
        return adresseMapper.entityToDTO(newAdresse);
    }
    
}
