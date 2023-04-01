package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "chemin")
    private String chemin;
    @Column(name = "resolutionPx")
    private Float resolutionPx;
    @Column(name = "infoPdv")
    private String infoPdv;
    @Column(name = "partagee")
    private boolean partagee;

    @OneToOne
    private Client clientImage;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getChemin() {
        return chemin;
    }
    public void setChemin(String chemin) {
        this.chemin = chemin;
    }
    public Float getResolutionPx() {
        return resolutionPx;
    }
    public void setResolutionPx(Float resolutionPx) {
        this.resolutionPx = resolutionPx;
    }
    public String getInfoPdv() {
        return infoPdv;
    }
    public void setInfoPdv(String infoPdv) {
        this.infoPdv = infoPdv;
    }
    public boolean isPartagee() {
        return partagee;
    }
    public void setPartagee(boolean partagee) {
        this.partagee = partagee;
    }
    public Client getClientImage() {
        return clientImage;
    }
    public void setClientImage(Client clientImage) {
        this.clientImage = clientImage;
    }
    
}
