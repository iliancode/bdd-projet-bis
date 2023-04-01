package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Impression;
import fr.uga.l3miage.photonum.service.base.BaseService;

public interface ImpressionService extends BaseService<Impression, Long> {

    Impression save(Impression impression);


}