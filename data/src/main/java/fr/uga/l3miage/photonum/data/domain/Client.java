package fr.uga.l3miage.photonum.data.domain;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Adresse> adresses;

    @OneToMany (mappedBy = "clientCommande")
    private List<Commande> commandes;

    @OneToMany (mappedBy = "clientImage")
    private List<Image> images;

    @OneToMany (mappedBy = "clientImpression")
    private List<Impression> impressions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }


    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }

    public void addAdresse(Adresse adresse) {
        if (this.adresses == null) {
            this.adresses = new ArrayList<>();
        }
        this.adresses.add(adresse);
    }
    public void removeAdresse(Adresse adresse) {
        if (this.adresses!= null) {
            this.adresses.remove(adresse);
        }
    }
    public List<Commande> getCommandes() {
        return this.commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public void addCommande(Commande commande) {
        if (this.commandes == null) {
            this.commandes = new ArrayList<Commande>();
        }
        this.commandes.add(commande);
    }
    
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void addImage(Image image) {
        if (this.images == null) {
            this.images = new ArrayList<>();
        }
        this.images.add(image);
    }

    public List<Impression> getImpressions() {
        return impressions;
    }

    public void setImpressions(List<Impression> impressions) {
        this.impressions = impressions;
    }

    public void addImpression(Impression impression) {
        if (this.impressions == null) {
            this.impressions = new ArrayList<>();
        }
        this.impressions.add(impression);
    }
    
}
