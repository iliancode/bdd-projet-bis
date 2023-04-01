package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "photo")
public class Photo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "texteDescriptif")
    private String texteDescriptif;
    @Column(name = "parametreRetouche")
    private String parametreRetouche;
    @OneToOne
    private Image image;
    

}
