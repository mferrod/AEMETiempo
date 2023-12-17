package com.example.aemetiempo.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.aemetiempo.Controller.MainController;
import com.example.aemetiempo.Model.Localidad;
import com.example.aemetiempo.Model.TemporalAdapter;
import com.example.aemetiempo.Model.Tiempo;
import com.example.aemetiempo.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Spinner spinner;
    private String[] arroncsv;
    private static MainActivity activity;
    private RecyclerView mRecyclerView;
    private TemporalAdapter mAdapter;
    private LinkedList<Tiempo> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.varDeclarations();
        this.editTextLook();
        this.spinnerMaker();
        MainActivity.activity = this;
        MainController.setActivity(this);
    }
    private void varDeclarations() {
        editText = findViewById(R.id.etLocalidad);
        spinner = findViewById(R.id.spinnerSelector);
        arroncsv = getResources().getStringArray(R.array.localidadescsveadas);
        mList = new LinkedList<>();
        mRecyclerView = findViewById(R.id.rvData);
        mAdapter = new TemporalAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
                if (i > 2) {
                    spinner.setAdapter(null); //Elimino todos los datos que haya?
                    spinnerAddOptions();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                return;
            }
        });
    }
    private void spinnerAddOptions() {
        MainController.getSingleton().getLocalidades(
                String.valueOf(editText.getText()), arroncsv);
        ArrayList<Localidad> local = MainController.getSingleton().getLocalidadesSeleccionadas();
        String[] localnames = new String[local.size()];
        for (int i = 0; i < local.size(); i++)
            localnames[i] = local.get(i).getNombreLocalidad();
        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, localnames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(arrayAdapter);
    }
    private void spinnerMaker() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int list = 0;
                ArrayList<Localidad> local = MainController.getSingleton().getLocalidadesSeleccionadas();
                while (!local.get(list).getNombreLocalidad().equals(spinner.getSelectedItem().toString()))
                    list++;
                MainController.getSingleton().getDataFromAEMET(
                        local.get(list).getCprovincia() +
                        local.get(list).getCodmunicipio());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }
    public void setError(String error) {
        TextView tv = findViewById(R.id.tvResults);
        tv.setText(error);
    }

    public void accessToData() {
        //Get data from servers throgh controller-model classes
        List<Tiempo> nuevaLista = MainController.getSingleton().dameDatosTiempo();

        //Put data in adapter
        mList.clear();
        for (Tiempo item:nuevaLista) {
            mList.add(item);
        }
        mAdapter.notifyDataSetChanged();
    }
}