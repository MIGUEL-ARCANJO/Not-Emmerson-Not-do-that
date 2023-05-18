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

import com.example.funcionarioarrayadapter.controller.FuncionarioController;
import com.example.funcionarioarrayadapter.model.Funcionario;

public class AtualizarFuncionario extends AppCompatActivity {

    private Button update, delete;
    private EditText nome, cargo;
    private Spinner sexo;

    private char sexoVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_funcionario);
        initComponents();
        loadComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FuncionarioController controller = FuncionarioController.getController();

        sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sexoVal = sexo.getSelectedItem().equals("Masculino") ? 'M' : 'F';
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        update.setOnClickListener(view -> {
            String nomeVal = nome.getText().toString().trim(),
                    cargoVal = cargo.getText().toString().trim();


            controller.updateFuncionario(new Funcionario(nomeVal,cargoVal,sexoVal), MainActivity.getIndex());
            System.out.println(sexoVal);
            finish();
        });

        delete.setOnClickListener(view -> {
            controller.deleteFuncionario(MainActivity.getIndex());
            finish();
        });
    }

    private void initComponents() {
        update = findViewById(R.id.atualizar);
        delete = findViewById(R.id.deletar);

        nome = findViewById(R.id.nome);
        cargo = findViewById(R.id.cargo);
        sexo = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sexoArray, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexo.setAdapter(adapter);
    }

    private void loadComponents() {

        Funcionario funcionarioVal = FuncionarioController.getController().listFuncionarioByIndex(MainActivity.getIndex());

        nome.setText(funcionarioVal.getNome());
        cargo.setText(funcionarioVal.getCargo());

        if (funcionarioVal.getSexo() == 'M') {
            sexo.setSelection(0);
        } else {
            sexo.setSelection(1);
        }
    }

}