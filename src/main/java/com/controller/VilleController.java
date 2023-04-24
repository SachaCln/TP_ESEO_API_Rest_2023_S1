package com.controller;


import com.blo.VilleBLO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleController {

    @Autowired
    private VilleBLO villeBLO;

    @GetMapping("/postal")
    public String getVillesPostal(@RequestParam(required = false, name = "codePostal") String codePostal) {
        return villeBLO.getInfoVille(codePostal);
    }

    @GetMapping
    public List<Ville> getVilles() {
        return villeBLO.getVilles();
    }

    @GetMapping("/{nom}")
    public Ville getVille(@PathVariable String nom) {
        return villeBLO.getVilleByNom(nom);
    }

    @PostMapping
    public void addVille(@RequestBody Ville ville) {
        villeBLO.addVille(ville);
    }

    @PutMapping("/{nom}")
    public void updateVille(@RequestBody Ville ville) {
        villeBLO.updateVille(ville);
    }

    @DeleteMapping("/{nom}")
    public void deleteVille(@PathVariable String nom) {
        villeBLO.deleteVille(nom);
    }
}

