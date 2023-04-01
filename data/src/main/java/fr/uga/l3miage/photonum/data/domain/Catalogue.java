package fr.uga.l3miage.photonum.data.domain;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "catalogue")
public class Catalogue {
    @Id 
    @GeneratedValue
    private Long id;
    @OneToMany
    private List<LigneCatalogue> lignesCatalogue;
     
}
