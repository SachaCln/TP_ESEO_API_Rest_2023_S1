package com.blo;

import com.dto.Ville;

import java.util.ArrayList;
import java.util.List;

public interface VilleBLO {
    public String getInfoVille(String codePostal);
    public List<Ville> getVilles();
    public Ville getVilleByNom(String nom);
    public void addVille(Ville ville);
    public void updateVille(Ville ville);
    public void deleteVille(String nomVille);

}