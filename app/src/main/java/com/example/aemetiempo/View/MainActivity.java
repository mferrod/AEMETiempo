package com.example.aemetiempo.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.aemetiempo.R;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.varDeclarations();
        this.addOptionsToSpinner();
    }
    private void varDeclarations() {
        spinner = findViewById(R.id.sProvincias);
    }
    private void addOptionsToSpinner() {
        String[] sta = getResources().getStringArray(R.array.provincias);
        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sta);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(arrayAdapter);
    }
}