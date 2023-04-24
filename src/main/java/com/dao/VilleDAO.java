package com.dao;

import com.dto.Ville;

import java.util.ArrayList;
import java.util.List;

public interface VilleDAO {
    public ArrayList<Ville> findAllVilles();
    public Ville getVilleByNom(String ville);
    public ArrayList<Ville> recupererVilles() ;
    public void save(Ville ville);
    public void updateVille(Ville ville);
    public void deleteVille(String nomVille);
}
