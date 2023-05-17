package com.example.funcionarioarrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.funcionarioarrayadapter.model.Funcionario;

import java.util.ArrayList;
import java.util.Random;

public class CadastroFuncionario extends AppCompatActivity {

    private Spinner spinner;
    private Button btnCadastro;
    private EditText nome, cargo;
    private static ArrayList<Funcionario> arrayFuncionario = new ArrayList<>();

    private String nomeVal, cargoVal;
    private char sexoVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_funcionario);
        getSupportActionBar().hide();

        initComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                sexoVal = spinner.getSelectedItem().equals("Masculino") ? 'M' : 'F';

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btnCadastro.setOnClickListener(view -> {

            nomeVal = nome.getText().toString().trim();
            cargoVal = cargo.getText().toString().trim();

            if(verificarCampos(nomeVal, cargoVal)){
                getArrayFuncionario().add(new Funcionario(new Random().nextInt(), nomeVal, sexoVal, cargoVal));
                for (Funcionario funcs :
                        getArrayFuncionario()) {
                    System.out.println(funcs.toString());
                }
                startActivity(new Intent(this, MainActivity.class));
            }
        });

    }

    private Boolean verificarCampos(String nomeVef, String cargoVef) {
        Boolean isTrue = true;
        if(nomeVef.isEmpty()){
            nome.setError("Por favor, Informe o nome!");
            isTrue = false;
        }
        if (cargoVef.isEmpty()) {
            cargo.setError("Por favor, Informe o cargo!");
            isTrue = false;
        }
        return isTrue;
    }

    private void initComponents() {
        spinner = findViewById(R.id.spinner);
        btnCadastro = findViewById(R.id.cadastrar);
        nome = findViewById(R.id.nome);
        cargo = findViewById(R.id.cargo);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sexoArray, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public static ArrayList<Funcionario> getArrayFuncionario() {
        return arrayFuncionario;
    }

}