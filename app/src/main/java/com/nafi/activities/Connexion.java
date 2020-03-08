package com.nafi.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nafi.projet_android.R;
import com.nafi.projet.Compte;
import com.nafi.projet.CompteDao;

/**
 * Created by mouride on 20/04/2019.
 */
public class Connexion extends AppCompatActivity {
    EditText login,password;
    Button btnConnexion;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        login= (EditText) findViewById(R.id.logincnx);
        password = (EditText) findViewById(R.id.passworwcnx);
        btnConnexion = (Button) findViewById(R.id.btnConnexion);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        verifier();
    }
    public void verifier(){
        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(login.getText().toString().equals("") || password.getText().toString().equals("")){
                    Toast.makeText(Connexion.this,"Veuillez remplir les champs vide",Toast.LENGTH_SHORT).show();
                }else{
                    Compte compte = new Compte();
                    CompteDao compteDao = new CompteDao(Connexion.this);
                    compte = compteDao.verifier(login.getText().toString(),password.getText().toString());
                    if(compte.getIdCompte() > 0 ){
                        editor = sharedPreferences.edit();
                        editor.putInt("id",compte.getIdCompte());
                        editor.commit();
                        Toast.makeText(Connexion.this," Connexion reussi",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Connexion.this,Menu.class));
                        finish();
                    }else {
                        Toast.makeText(Connexion.this," Nom d'utilisateur ou mot de passe incorrecte !!!",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            });

    }
}
