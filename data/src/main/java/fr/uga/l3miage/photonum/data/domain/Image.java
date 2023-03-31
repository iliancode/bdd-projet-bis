package fr.uga.l3miage.photonum.data.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "chemin")
    private String chemin;
    @Column(name = "resolutionPx")
    private Float resolutionPx;
    @Column(name = "infoPdv")
    private String infoPdv;
    @Column(name = "partagee")
    private boolean partagee;

    @OneToOne
    private Client clientImage;
}
