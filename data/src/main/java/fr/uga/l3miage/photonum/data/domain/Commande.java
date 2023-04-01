package fr.uga.l3miage.photonum.data.domain;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "dateCommande")
    private Date dateCommande;
    @Column(name = "prixTotal")
    private Float prixTotal;

    @OneToOne
    private Client clientCommande;

    @OneToMany
    private List<Article> articles;
}
