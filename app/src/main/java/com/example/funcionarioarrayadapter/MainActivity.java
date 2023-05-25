package com.example.funcionarioarrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.funcionarioarrayadapter.controller.FuncionarioController;
import com.example.funcionarioarrayadapter.model.Funcionario;
import com.example.funcionarioarrayadapter.model.ListFuncionarioAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button cadastro, clear, btnCustom;
    private ListView lista;
    private static int index;
    private FuncionarioController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initComponents();

        lista.setAdapter(new ListFuncionarioAdapter(this,
                (ArrayList<Funcionario>) FuncionarioController.getController().listFuncionario()));

    }

    @Override
    protected void onResume() {
        super.onResume();
        lista.setAdapter(new ListFuncionarioAdapter(this,
                (ArrayList<Funcionario>) FuncionarioController.getController().listFuncionario()));
    }


    @Override
    protected void onStart() {
        super.onStart();

        cadastro.setOnClickListener(view -> {

            startActivity(new Intent(MainActivity.this, CadastroFuncionario.class));


        });

        lista.setOnItemLongClickListener((parent, view, position, id) -> {
            setIndex(position);

            customDialog();
            return false;
        });

        lista.setOnItemClickListener((adapterView, view, i, l) -> {

            setIndex(i);
            startActivity(new Intent(this, AtualizarFuncionario.class));
        });

        clear.setOnClickListener(view -> {
            if (CadastroFuncionario.getArrayFuncionario().isEmpty()) {
                Toast.makeText(this, "A lista já está vazia", Toast.LENGTH_SHORT).show();
            } else {
                lista.setAdapter(new ListFuncionarioAdapter(this,
                        CadastroFuncionario.getArrayFuncionario()));
                CadastroFuncionario.getArrayFuncionario().clear();
            }
        });

    }

    private void customDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialog_funcionario);

        Button btn = dialog.findViewById(R.id.buttonCustom);
        ImageView cancelar = dialog.findViewById(R.id.cancelar);
        btn.setOnClickListener(v -> {

            controller.deleteFuncionario(getIndex());
            dialog.dismiss();
            lista.setAdapter(new ListFuncionarioAdapter(this,
                    (ArrayList<Funcionario>) FuncionarioController.getController().listFuncionario()));
        });

        cancelar.setOnClickListener(v -> {
            dialog.dismiss();
        });

        dialog.show();
    }

    public static void setIndex(int index) {
        MainActivity.index = index;
    }

    public static int getIndex() {
        return index;
    }

    private void initComponents() {
        cadastro = findViewById(R.id.cadastro);
        clear = findViewById(R.id.update);
        lista = findViewById(R.id.lista);
        controller = FuncionarioController.getController();
        setIndex(0);
    }
}