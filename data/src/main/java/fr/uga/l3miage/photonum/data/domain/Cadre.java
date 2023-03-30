package fr.uga.l3miage.photonum.data.domain;


import fr.uga.l3miage.photonum.data.Enum.QualiteCadre;
import fr.uga.l3miage.photonum.data.Enum.TailleCadre;
import fr.uga.l3miage.photonum.data.domain.Impression;

public class Cadre extends Impression{

    private Page page;

    private TailleCadre tailleCadre;
    private QualiteCadre qualiteCadre;
}