package fr.uga.l3miage.photonum.data.domain;

import java.util.Date;
import java.util.Set;

public class Commande {
    private Long id;
    private Date dateCommande;
    private Float prixTotal;

    private Client client;

    private Set<Article> articles;
}
