package com.iam.activities;

/**
 * Created by ibra on 27/03/2018.
 */
public class Agence {
    private String nom;
    private String tel;

    public Agence(String nom, String tel) {
        this.nom = nom;
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
