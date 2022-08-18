package com.example.prefrenceex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MainActivity2 extends PreferenceActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);
        addPreferencesFromResource(R.xml.prefs);

    }
}