package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.service.base.BaseService;

public interface AdresseService extends BaseService<Adresse, Long> {

    Adresse save(Adresse adresse);

    
}