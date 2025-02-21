package com.isi.maven.services.controller;

import com.isi.maven.services.service.IcommandeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commandes")  // Ajout d'un préfixe commun pour l'API
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") // Autoriser Angular
public class ICommandeController {

    private final IcommandeService icommandeService;

    @GetMapping
    public String getCommande() {
        return icommandeService.getCommande();
    }

    @GetMapping("/somme")
    public Integer getSomme(@RequestParam int a, @RequestParam int b) {
        return icommandeService.somme(a, b);
    }
}
