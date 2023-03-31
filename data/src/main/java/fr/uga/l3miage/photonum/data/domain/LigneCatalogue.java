package fr.uga.l3miage.photonum.data.domain;

import fr.uga.l3miage.photonum.data.Enum.Reference;
import fr.uga.l3miage.photonum.data.Enum.TypeImpression;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ligneCatalogue")
public class LigneCatalogue {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "tarif")
    private Float tarif;
    @Column(name = "reference")
    private Reference reference;
    @Column(name = "typeImpression")
    private TypeImpression typeImpression;
}
