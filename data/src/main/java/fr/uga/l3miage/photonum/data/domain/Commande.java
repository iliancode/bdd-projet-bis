package main.java.fr.uga.l3miage.photonum.data.domain;

public class Commande {
    private Long id;
    private Date dateCommande;
    private Float prixTotal;

    private Client client;

    private Set<Article> articles;
}
