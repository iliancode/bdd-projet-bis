package fr.uga.l3miage.photonum.data.domain;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Album extends Impression{

    @Column(name = "titre")
    private String titre;

    @OneToMany
    private List<Page> pages; //1..*


    //getter setter
}
