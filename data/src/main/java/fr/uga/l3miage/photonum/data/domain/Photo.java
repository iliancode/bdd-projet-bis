package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "photo")
public class Photo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "texteDescriptif")
    private String texteDescriptif;
    @Column(name = "parametreRetouche")
    private String parametreRetouche;
    @OneToOne
    private Image image;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTexteDescriptif() {
        return texteDescriptif;
    }
    public void setTexteDescriptif(String texteDescriptif) {
        this.texteDescriptif = texteDescriptif;
    }
    public String getParametreRetouche() {
        return parametreRetouche;
    }
    public void setParametreRetouche(String parametreRetouche) {
        this.parametreRetouche = parametreRetouche;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    
}
