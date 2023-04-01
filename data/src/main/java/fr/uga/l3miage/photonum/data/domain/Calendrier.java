package fr.uga.l3miage.photonum.data.domain;


import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Calendrier extends Impression{

    @OneToMany
    private List<Page> pages; //12 pages
}
