package fr.uga.l3miage.photonum.data.domain;

import java.util.Set;

public class Album extends Impression{
    private String titre;

    private Set<Page> pages; //1..*

}
