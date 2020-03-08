package com.iam.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ibra.com.iam.projet_android.R;

public class ListeAgence extends AppCompatActivity {
ListView listView;
    private String[] agence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_agence);
        List<Agence> agences = new ArrayList<>();
        agences.add(new Agence("Agence de dakar","338523252"));
        agences.add(new Agence("Agence de koaloack","338523252"));
        agences.add(new Agence("Agence de thies","338523252"));
        agences.add(new Agence("Agence de fatick","338523252"));
        agences.add(new Agence("Agence de Diourbel","338523252"));
        agences.add(new Agence("Agence de Tamba","338523252"));
        agences.add(new Agence("Agence de kedougou","338523252"));
        agences.add(new Agence("Agence de louga","338523252"));
        agences.add(new Agence("Agence de Tivaoune","338523252"));
        agences.add(new Agence("Agence de Saint-louis","338523252"));

        ListeAgenceAdapater arrayAdapter = new ListeAgenceAdapater(this,R.layout.layout_list_item, agences);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);

    }
}
