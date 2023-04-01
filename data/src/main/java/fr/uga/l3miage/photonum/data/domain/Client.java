package fr.uga.l3miage.photonum.data.domain;

import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
    
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "mail")
    private String mail;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "motDePasse")
    private String motDePasse;

    @OneToMany
    private List<Adresse> adresses;

    @OneToMany (mappedBy = "clientCommande")
    private List<Commande> commandes;

    @OneToMany (mappedBy = "clientImage")
    private List<Image> images;

    @OneToMany (mappedBy = "clientImpression")
    private List<Impression> impressions;
}
