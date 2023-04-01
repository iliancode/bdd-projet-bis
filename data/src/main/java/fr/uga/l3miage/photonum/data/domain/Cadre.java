package fr.uga.l3miage.photonum.data.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import main.java.fr.uga.l3miage.photonum.data.Enum.QualiteCadre;
import main.java.fr.uga.l3miage.photonum.data.Enum.TailleCadre;

@Entity
public class Cadre extends Impression{

    @OneToOne
    private Page page;

    @Column(name = "tailleCadre")
    private TailleCadre tailleCadre;
    @Column(name = "qualiteCadre")
    private QualiteCadre qualiteCadre;
}