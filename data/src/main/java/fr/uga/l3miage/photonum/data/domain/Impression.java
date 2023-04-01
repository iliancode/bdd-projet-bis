package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.*;
import main.java.fr.uga.l3miage.photonum.data.Enum.TypeImpression;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS )
public class Impression {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id; // remplacer car String si besoin

    @ManyToOne 
    private Client clientImpression;

    @Enumerated(EnumType.STRING)
    @Column(name = "typeImpression")
    private TypeImpression typeImpression;

    //getter et setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClientImpression() {
        return clientImpression;
    }

    public void setClientImpression(Client clientImpression) {
        this.clientImpression = clientImpression;
    }

    public TypeImpression getTypeImpression() {
        return typeImpression;
    }

    public void setTypeImpression(TypeImpression typeImpression) {
        this.typeImpression = typeImpression;
    }
}
