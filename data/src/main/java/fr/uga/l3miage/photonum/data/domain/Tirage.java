package fr.uga.l3miage.photonum.data.domain;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Tirage extends Impression {
    @OneToMany
    private List<PhotoTirage> photosTirage;
}
