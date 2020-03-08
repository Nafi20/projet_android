package com.nafi.projet;

/**
 * Created by ibra on 19/03/2018.
 */
public class Compte {
    private int idCompte;
    private int solde;
    private String login;
    private String password;

    public Compte() {
    }

    public Compte(int idCompte, int solde, String login, String password) {
        this.idCompte = idCompte;
        this.solde = solde;
        this.login = login;
        this.password = password;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
