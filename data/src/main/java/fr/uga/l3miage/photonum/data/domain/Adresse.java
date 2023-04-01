package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "adresse")
public class Adresse {
    
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "numero_rue")
    private int numeroRue;
    @Column(name = "rue")
    private String rue;
    @Column(name = "ville")
    private String ville;
    @Column(name = "code_postal")
    private String codePostal;
    @Column(name = "pays")
    private String pays;

    // getter setter

}
