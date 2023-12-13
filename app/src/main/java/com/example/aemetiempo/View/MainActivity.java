package com.example.aemetiempo.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.aemetiempo.Controller.MainController;
import com.example.aemetiempo.Model.Localidad;
import com.example.aemetiempo.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Spinner spinner;
    private String[] arroncsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.varDeclarations();
        this.editTextLook();
        this.spinnerMaker();
    }
    private void varDeclarations() {
        editText = findViewById(R.id.etLocalidad);
        spinner = findViewById(R.id.spinnerSelector);
        arroncsv = getResources().getStringArray(R.array.localidadescsveadas);
    }

    private void editTextLook() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                return;
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Con esto busco coincidencias -- POR DESARROLLAR
                spinner.setAdapter(null); //Elimino todos los datos que haya?
                spinnerAddOptions();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                return;
            }
        });
    }
    private void spinnerAddOptions() {
        if (!(editText.getText().equals(""))) {
            ArrayList<Localidad> local = MainController.getSingleton().getLocalidades(
                    String.valueOf(editText.getText()), arroncsv);
            String[] localnames = new String[local.size()];
            for (int i = 0; i < local.size(); i++)
                localnames[i] = local.get(i).getNombreLocalidad();
            ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, localnames);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spinner.setAdapter(arrayAdapter);
        }
    }
    private void spinnerMaker() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }
}