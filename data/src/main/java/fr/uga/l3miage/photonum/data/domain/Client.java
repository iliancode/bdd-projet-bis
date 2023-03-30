package fr.uga.l3miage.photonum.data.domain;

import java.util.*;

import fr.uga.l3miage.photonum.data.domain.Impression;

public class Client {
    
    private String mail;
    
    private String nom;
    private String prenom;
    private String motDePasse;

    private Set<Adresse> adresses;

    private Set<Commande> commandes;

    private Set<Image> images;

    private Set<Impression> impressions;
}
