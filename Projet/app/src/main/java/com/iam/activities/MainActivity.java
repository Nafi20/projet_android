package com.iam.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iam.projet.Compte;
import com.iam.projet.CompteDao;
import ibra.com.iam.projet_android.R;

public class MainActivity extends AppCompatActivity {
  EditText login,password,repeatpassword;
    Button btnIncription;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
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
                        CompteDao compteDao = new CompteDao(MainActivity.this);
                        Compte compte = new Compte(0,10000, log,pwd);
                        try{
                            compteDao.ajouterCompte(compte);
                            editor = sharedPreferences.edit();
                            editor.putString("ins","1");
                            editor.commit();
                            Toast.makeText(MainActivity.this,"insertion avec succés",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(MainActivity.this,Connexion.class));
                            finish();

                        }catch (Exception ex){
                            Toast.makeText(MainActivity.this," "+ex,Toast.LENGTH_LONG).show();
                        }

                    }else {
                        Toast.makeText(MainActivity.this,"Les mots de passe ne sont pas identiques",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Veuillez remplir les champs vide ",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void verifier(){
        String verif = sharedPreferences.getString("ins","0");
        if(verif.equals("1")){
            startActivity(new Intent(MainActivity.this,Connexion.class));
            finish();
        }
    }
}
