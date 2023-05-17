package com.example.funcionarioarrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.funcionarioarrayadapter.model.ListFuncionarioAdapter;

public class MainActivity extends AppCompatActivity {
    private Button cadastro, clear;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initComponents();

        if (!CadastroFuncionario.getArrayFuncionario().isEmpty()) {

            lista.setAdapter(new ListFuncionarioAdapter(this,
                    CadastroFuncionario.getArrayFuncionario()));

        } else {
            Toast.makeText(this, "Nenhum funcionario cadastrado!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        cadastro.setOnClickListener(view -> {

            startActivity(new Intent(MainActivity.this, CadastroFuncionario.class));

        });

        clear.setOnClickListener(view -> {
            if(CadastroFuncionario.getArrayFuncionario().isEmpty()){
                Toast.makeText(this, "A lista já está vazia", Toast.LENGTH_SHORT).show();
            }else{
                lista.setAdapter(new ListFuncionarioAdapter(this,
                        CadastroFuncionario.getArrayFuncionario()));
                CadastroFuncionario.getArrayFuncionario().clear();
            }
        });

    }

    private void initComponents() {
        cadastro = findViewById(R.id.cadastro);
        clear = findViewById(R.id.update);
        lista = findViewById(R.id.lista);
    }
}