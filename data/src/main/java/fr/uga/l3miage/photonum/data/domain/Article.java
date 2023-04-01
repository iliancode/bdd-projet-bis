package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import main.java.fr.uga.l3miage.photonum.data.Enum.Reference;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "prix")
    private float prix;
    @Column(name = "quantite")
    private int quantite;
    @Column(name = "reference")
    private Reference reference;

    @ManyToOne
    private Impression impression;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
