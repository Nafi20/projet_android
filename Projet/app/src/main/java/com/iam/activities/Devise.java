package com.iam.activities;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import ibra.com.iam.projet_android.R;

/**
 * Created by ibra on 20/03/2018.
 */
public class Devise extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
