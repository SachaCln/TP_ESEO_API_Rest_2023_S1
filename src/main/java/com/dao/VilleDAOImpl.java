package com.dao;

import com.dto.Ville;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VilleDAOImpl implements VilleDAO {
    private Connection connexion;

    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/villeFrance", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Ville> findAllVilles() {
        System.out.println("findAllVilles");
        ArrayList<Ville> listVille = new ArrayList<>();

        Ville ville = new Ville();
        ville.setCodePostal("49000");
        ville.setNom("Angers");
        ville.setLigne("ligne");
        listVille.add(ville);

        return listVille;
    }

    public ArrayList<Ville> recupererVilles() {
        ArrayList<Ville> villes = new ArrayList<Ville>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();

        try {
            statement = connexion.createStatement();
            // Exécution de la requête
            resultat = statement.executeQuery("SELECT Nom_commune, Code_postal, Latitude, Longitude from ville_france;");
            // Récupération des données
            while (resultat.next()) {
                Ville ville = new Ville();
                ville.setNom(resultat.getString("Nom_commune"));
                ville.setCodePostal(resultat.getString("Code_postal"));
                ville.setLatitude(resultat.getString("Latitude"));
                ville.setLongitude(resultat.getString("Longitude"));
                villes.add(ville);
            }
        } catch (SQLException e) {
            // Gérer l'exception
        } finally {
            // Fermeture de la connexion
            closeStatement(statement);
            closeResultSet(resultat);
            closeConnection();
        }

        return villes;
    }

    @Override
    public void save(Ville ville) {
        PreparedStatement statement = null;
        loadDatabase();
        try {
            String sql = "INSERT INTO `ville_france`(`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = connexion.prepareStatement(sql);
            statement.setString(1, ville.getCodeCommune());
            statement.setString(2, ville.getNom());
            statement.setString(3, ville.getCodePostal());
            statement.setString(4, ville.getLibelle());
            statement.setString(5, ville.getLigne());
            statement.setString(6, ville.getLatitude());
            statement.setString(7, ville.getLongitude());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Gérer l'exception
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public void deleteVille(String nomVille) {
        PreparedStatement statement = null;
        loadDatabase();
        try {
            String sql = "DELETE FROM `ville_france` WHERE Nom_commune = ?";
            statement = connexion.prepareStatement(sql);
            statement.setString(1, nomVille);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Gérer l'exception
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public void updateVille(Ville ville) {
        PreparedStatement statement = null;
        loadDatabase();
        try {
            String sql = "UPDATE `ville_france` SET `Code_commune_INSEE`=?, `Nom_commune`=?, `Code_postal`=?, `Libelle_acheminement`=?, `Ligne_5`=?, `Latitude`=?, `Longitude`=? WHERE Nom_commune = ?";
            statement = connexion.prepareStatement(sql);
            statement.setString(1, ville.getCodeCommune());
            statement.setString(2, ville.getNom());
            statement.setString(3, ville.getCodePostal());
            statement.setString(4, ville.getLibelle());
            statement.setString(5, ville.getLigne());
            statement.setString(6, ville.getLatitude());
            statement.setString(7, ville.getLongitude());
            statement.setString(8, ville.getNom());
            statement.executeUpdate();
        } catch (SQLException e) {
        // Gérer l'exception
        } finally {
            closeStatement(statement);
            closeConnection();
        }
    }

    @Override
    public Ville getVilleByNom(String nomVille) {
        Ville ville = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
            loadDatabase();
            String sql = "SELECT Nom_commune, Code_postal, Latitude, Longitude FROM ville_france WHERE Nom_commune = ?";
            statement = connexion.prepareStatement(sql);
            statement.setString(1, nomVille);
            resultat = statement.executeQuery();
            if (resultat.next()) {
                ville = new Ville();
                ville.setNom(resultat.getString("Nom_commune"));
                ville.setCodePostal(resultat.getString("Code_postal"));
                ville.setLatitude(resultat.getString("Latitude"));
                ville.setLongitude(resultat.getString("Longitude"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultat);
            closeStatement(statement);
            closeConnection();
        }

        return ville;
    }



    private void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                // Gérer l'exception
            }
        }
    }

    private void closeResultSet(ResultSet resultat) {
        if (resultat != null) {
            try {
                resultat.close();
            } catch (SQLException e) {
                // Gérer l'exception
            }
        }
    }

    private void closeConnection() {
        if (connexion != null) {
            try {
                connexion.close();
            } catch (SQLException e) {
                // Gérer l'exception
            }
        }
    }
}

