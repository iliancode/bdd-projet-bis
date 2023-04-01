package fr.uga.l3miage.photonum.data.repo;

import com.github.javafaker.Faker;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Impression;

import java.util.Random;

public class Fixtures {

    private static final Faker FAKER = Faker.instance(new Random(42));
    public static Adresse newAdresse() {
        Adresse adresse = new Adresse();
        adresse.setId(FAKER.number().randomNumber());
        adresse.setCodePostal(FAKER.address().countryCode());
        adresse.setVille(FAKER.address().city());
        adresse.setRue(FAKER.address().streetAddress());
        adresse.setNumeroRue(FAKER.number().randomDigit());
        adresse.setPays(FAKER.address().country());
        return adresse;
    }

    public static Image newImage() {
        Image image = new Image();
        image.setId(FAKER.number().randomNumber());
        image.setChemin(FAKER.internet().url());
        image.setInfoPdv("test");
        image.setPartagee(false);
        image.setResolutionPx(1080f);
        return image;
    }

    

    public static Client newClient() {
        Client client = new Client();
        client.setNom(FAKER.name().lastName());
        client.setPrenom(FAKER.name().firstName());
        client.setMail(FAKER.internet().emailAddress());
        client.setMotDePasse(null);
        return client;
    }

    public static Impression newImpression() {
        Impression impression = new Impression();
        // ...
        return impression;
    }
}
