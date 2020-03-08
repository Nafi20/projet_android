package com.iam.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.iam.projet.Compte;
import com.iam.projet.CompteDao;
import ibra.com.iam.projet_android.R;

public class Menu extends AppCompatActivity {
Button devise, solde, listeAgences,listeContacts, mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        devise = (Button) findViewById(R.id.devise);
        solde = (Button) findViewById(R.id.solde);
        listeAgences = (Button) findViewById(R.id.listeAgences);
        listeContacts = (Button) findViewById(R.id.listeContacts);
        mail = (Button) findViewById(R.id.mail);
        action();
    }
    public void action(){
        devise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this,Devise.class));
            }
        });
        solde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Compte compte = new Compte();
                CompteDao compteDao = new CompteDao(Menu.this);
                SharedPreferences preferenceManager = PreferenceManager.getDefaultSharedPreferences(Menu.this);
                int id =preferenceManager.getInt("id",0);
                compte = compteDao.recupSolde(id);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Menu.this);
                alertDialog.setTitle("Consultation du solde")
                        .setMessage("Votre solde est : " + compte.getSolde());
                alertDialog.show();

            }
        });
        listeAgences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this,ListeAgence.class));
            }
        });
        listeContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("content://contacts/people");
                Intent intent =new  Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Menu.this);
                alertDialog.setTitle("Adresse Mail de la banque Mouride")
                        .setMessage("mouride@banque.com");
                alertDialog.show();

            }
        });
    }

}
