package fr.uga.l3miage.photonum.data.domain;


import fr.uga.l3miage.photonum.data.Enum.QualiteCadre;
import fr.uga.l3miage.photonum.data.Enum.TailleCadre;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Cadre extends Impression{

    @OneToOne
    private Page page;

    @Column(name = "tailleCadre")
    private TailleCadre tailleCadre;
    @Column(name = "qualiteCadre")
    private QualiteCadre qualiteCadre;
}