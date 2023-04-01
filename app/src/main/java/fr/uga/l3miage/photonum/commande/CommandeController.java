package fr.uga.l3miage.photonum.commande;

import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("")
    public ResponseEntity<Collection<Commande>> getAllCommandes() {
        Collection<Commande> commandes = commandeService.list();
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable("id") Long id) {
        try {
            Commande commande = commandeService.get(id);
            return new ResponseEntity<>(commande, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        Commande savedCommande = commandeService.save(commande);
        return new ResponseEntity<>(savedCommande, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable("id") Long id, @RequestBody Commande commande) {
        try {
            Commande updatedCommande = commandeService.update(commande);
            return new ResponseEntity<>(updatedCommande, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCommande(@PathVariable("id") Long id) {
        try {
            commandeService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @GetMapping("/client/{id}")
    // public ResponseEntity<Collection<Commande>> getCommandesByClient(@PathVariable("id") Long id) {
    //     try {
    //         Client client = new Client(id);
    //         Collection<Commande> commandes = commandeService.getByClient(client);
    //         return new ResponseEntity<>(commandes, HttpStatus.OK);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }
}
