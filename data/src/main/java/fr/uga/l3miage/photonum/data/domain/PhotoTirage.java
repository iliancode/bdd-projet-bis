package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity
public class PhotoTirage extends Photo{
    @Column(name = "nbExemplaire")
    private int nbExemplaire;
}
