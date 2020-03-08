package com.nafi.projet_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nafi.activities.Connexion;
import com.nafi.projet.*;

public class MainActivity extends AppCompatActivity {
    EditText login,password,repeatpassword;
    Button btnIncription;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (EditText) findViewById(R.id.login);
        password= (EditText) findViewById(R.id.password);
        repeatpassword = (EditText) findViewById(R.id.repeatpassword);
        btnIncription = (Button) findViewById(R.id.btnInscription);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        verifier();
        enregistrerCompte();
    }

    public void enregistrerCompte(){
        btnIncription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String log = login.getText().toString();
                String pwd = password.getText().toString();
                String rpwd = repeatpassword.getText().toString();
                if(!(log.equals("") || pwd.equals("") || rpwd.equals(""))){
                    if(pwd.equals(rpwd) ){
                        com.nafi.projet.CompteDao compteDao = new com.nafi.projet.CompteDao(com.nafi.projet_android.MainActivity.this);
                        com.nafi.projet.Compte compte = new com.nafi.projet.Compte(0,10000, log,pwd);
                        try{
                            compteDao.ajouterCompte(compte);
                            editor = sharedPreferences.edit();
                            editor.putString("ins","1");
                            editor.commit();
                            Toast.makeText(com.nafi.projet_android.MainActivity.this,"insertion avec succés",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(com.nafi.projet_android.MainActivity.this, Connexion.class));
                            finish();

                        }catch (Exception ex){
                            Toast.makeText(com.nafi.projet_android.MainActivity.this," "+ex,Toast.LENGTH_LONG).show();
                        }

                    }else {
                        Toast.makeText(com.nafi.projet_android.MainActivity.this,"Les mots de passe ne sont pas identiques",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(com.nafi.projet_android.MainActivity.this,"Veuillez remplir les champs vide ",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void verifier(){
        String verif = sharedPreferences.getString("ins","0");
        if(verif.equals("1")){
            startActivity(new Intent(com.nafi.projet_android.MainActivity.this,Connexion.class));
            finish();
        }
    }
}
