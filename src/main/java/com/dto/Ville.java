package com.dto;

public class Ville {
    private String codeCommune;
    private String nom;
    private String codePostal;
    private String libelle;
    private String ligne;
    private String latitude;
    private String longitude;

    public Ville() {
        this(null, null, null, null, null, null, null);
    }

    public Ville(String codeCommune, String nom, String codePostal, String libelle, String ligne, String latitude, String longitude) {
        this.codeCommune = codeCommune;
        this.nom = nom;
        this.codePostal = codePostal;
        this.libelle = libelle;
        this.ligne = ligne;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCodeCommune() {
        return codeCommune;
    }

    public void setCodeCommune(String codeCommune) {
        this.codeCommune = codeCommune;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getInfo() {
        return "Nom : " + nom + " Code Postal : " + codePostal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getLigne() {
        return ligne;
    }

    public void setLigne(String ligne) {
        this.ligne = ligne;
    }
}
